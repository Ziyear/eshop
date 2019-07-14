package com.eshop.common.aoplog;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志切点
 */
//@Aspect
//@Component
public class LogAspect {

//    @Reference
//    private UserActionLogMongoService userActionLogMongoService;
    /**
     * controller 切点
     */
    @Pointcut("@annotation(ControllerLogs)")
    public void controllerAspect(){

    }

    /**
     * service 切点
     */
    @Pointcut("@annotation(ServiceLogs)")
    public void serviceLogsAspect(){

    }


    /**
     * 前置通知, 用于拦截controller层用户记录操作
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //类名
            String className = joinPoint.getTarget().getClass().getName();
            //请求方法
            String method = joinPoint.getSignature().getName() + "()";
            //方法参数
            String methodParam = JSON.toJSONString(joinPoint.getArgs());
            //方法描述
            String methodDescription = getControllerMethodDescription(joinPoint);

            Map<String, String[]> params = request.getParameterMap();
            String decode = "";
            //针对get请求
            if(request.getQueryString()!=null){
                try {
                    decode = URLDecoder.decode(request.getQueryString(),"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else{
                //针对post请求
                for (String key : params.keySet()) {
                    String[] values = params.get(key);
                    for (int i = 0; i < values.length; i++) {
                        String value = values[i];
                        decode += key + "=" + value + "&";
                    }
                }
            }
            //将String根据&转成Map
            Map<String, Object> methodParamMap = transStringToMap(decode, "&", "=");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 后置通知增强处理，用于拦截controller层用户记录操作
     */
    @AfterReturning(returning = "ret",pointcut = "controllerAspect()")
    public void doAfterReturning(Object ret) throws Throwable{
        //获取返回的数据，暂不做处理
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        //请求方法
//        String method = StringUtils.abbreviate(request.getRequestURI(), 255);
//        StringBuilder sb = new StringBuilder(1000);
//        //处理完成， 返回内容
//        sb.append(";");
//        sb.append("Result : ").append(ret);
//        System.out.println(sb.toString());
        //logger.info(sb.toString());
    }

    /**
     * 异常通知， 用于拦截controller层一异常日志
     */
    @AfterThrowing(pointcut = "serviceLogsAspect()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable ex){
        try{
            //类名
            String className = joinPoint.getTarget().getClass().getName();
            //请求方法
            String method = (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            //方法参数
            String methodParam = Arrays.toString(joinPoint.getArgs());
            //方法描述
            String methodDescription = getServiceMthodDescription(joinPoint);
            //获取用户前请求方法的参数并序列化为JSON格式字符串
            StringBuilder params = new StringBuilder();
            if(joinPoint.getArgs() != null && joinPoint.getArgs().length > 0){
                for(int i = 0; i < joinPoint.getArgs().length; i++){
                    params.append(JSON.toJSONString(joinPoint.getArgs()[i])).append(";");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息， 用于Controller层注解
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods){
            if(method.getName().equals(methodName)) {
                Class[] clazz = method.getParameterTypes();
                if (clazz.length == arguments.length) {
                    description = method.getAnnotation(ControllerLogs.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * String 转Map
     * @param mapString 待转的String
     * @param separator 分割符
     * @param pairSeparator 分离器
     * @return
     */
    public static Map<String, Object> transStringToMap(String mapString, String separator, String pairSeparator) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] fSplit = mapString.split(separator);
        for (int i = 0; i < fSplit.length; i++) {
            if (fSplit[i]==null||fSplit[i].length()==0) {
                continue;
            }
            String[] sSplit = fSplit[i].split(pairSeparator);
            String value = fSplit[i].substring(fSplit[i].indexOf('=') + 1, fSplit[i].length());
            map.put(sSplit[0], value);
        }
        return map;
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint)throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ServiceLogs.class).description();
                    break;
                }
            }
        }
        return description;
    }


}
