package com.eshop.common.utils;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 接口返回类型工具类
 *
 * @author mhy
 * @since 2018-09-26
 */
public class ApiUtil implements Serializable {
    //接口报错后返回信息
    public static final String SERVER_ERROR = "服务器异常，请稍后再试";
    //接口查询数据为空
    public static final String NO_RESULT = "无数据";
    //接口查询数据成功
    public static final String SUCCESS = "获取成功";
    public static final String FAIL="common fail";
    public static final String error_invalid_argument="参数不合法";
    public static final String error_pic_file="非法图片文件";
    public static final String error_pic_upload="图片上传失败";
    public static final String error_record_not_found= "没有找到对应的数据";
    public static final String error_search_failed= "查询失败";
    public static final String error_duplicated_data="数据已存在";
    public static final String error_unknown_database_operation= "未知数据库操作失败，请联系管理员解决";
    public static final String error_file_download="文件下载失败";
    public static final String error_file_upload= "文件上传失败";
    public static final String error_add= "新增失败";
    public static final String error_update="修改失败";
    public static final String error_delete="删除失败";
    public static final String NOTLOGIN = "未登录";


    //100-511为http 状态码
    // --- 4xx Client Error ---
    public static final String http_status_bad_request="Bad Request";
    public static final String http_status_unauthorized= "Unauthorized";
    public static final String http_status_payment_required= "Payment Required";
    public static final String http_status_forbidden= "Forbidden";
    public static final String http_status_not_found= "Not Found";
    public static final String http_status_method_not_allowed="Method Not Allowed";

    // --- 5xx Server Error ---
    public static final String http_status_internal_server_error= "系统错误";
    public static final String http_status_not_implemented= "Not Implemented";
    public static final String http_status_bad_gateway= "Bad Gateway";
    public static final String http_status_service_unavailable= "Service Unavailable";
    public static final String http_status_gateway_timeout= "Gateway Timeout";

    //1000以内是系统错误，
    public static final String no_login= "没有登录";
    public static final String config_error= "参数配置表错误";
    public static final String user_exist= "用户名已存在";
    public static final String userpwd_not_exist= "用户名不存在或者密码错误";
    /**
     * @param baseApi
     * @param msg     错误信息
     * @return
     * @discription 添加失败信息
     * @author mhy
     * @date 2018-09-26 15:16
     */
    public static BaseApi addFailMessage(BaseApi baseApi, String msg) {
        if (baseApi != null) {
            baseApi.setCode("500");
            if (Constant.FAIL.equals(msg)) {
                baseApi.setMsg(FAIL);
                baseApi.setCode("-1");
            } else if (Constant.error_invalid_argument.equals(msg)) {
                baseApi.setMsg(error_invalid_argument);
                baseApi.setCode("100");
            } else if (Constant.error_pic_file.equals(msg)){
                baseApi.setMsg(error_pic_file);
                baseApi.setCode("300");
            }else if (Constant.error_pic_upload.equals(msg)){
                baseApi.setMsg(error_pic_upload);
                baseApi.setCode("301");
            }else if (Constant.error_record_not_found.equals(msg)){
                baseApi.setMsg(error_record_not_found);
                baseApi.setCode("302");
            }else if (Constant.error_search_failed.equals(msg)){
                baseApi.setMsg(error_search_failed);
                baseApi.setCode("303");
            }else if (Constant.error_duplicated_data.equals(msg)){
                baseApi.setMsg(error_duplicated_data);
                baseApi.setCode("304");
            }else if (Constant.error_unknown_database_operation.equals(msg)){
                baseApi.setMsg(error_unknown_database_operation);
                baseApi.setCode("305");
            }else if (Constant.error_file_download.equals(msg)){
                baseApi.setMsg(error_file_download);
                baseApi.setCode("306");
            }else if (Constant.error_file_upload.equals(msg)){
                baseApi.setMsg(error_file_upload);
                baseApi.setCode("307");
            }else if (Constant.http_status_bad_request.equals(msg)){
                baseApi.setMsg(http_status_bad_request);
                baseApi.setCode("400");
            }else if (Constant.http_status_unauthorized.equals(msg)){
                baseApi.setMsg(http_status_unauthorized);
                baseApi.setCode("401");
            }else if (Constant.http_status_forbidden.equals(msg)){
                baseApi.setMsg(http_status_forbidden);
                baseApi.setCode("403");
            }else if (Constant.http_status_payment_required.equals(msg)){
                baseApi.setMsg(http_status_payment_required);
                baseApi.setCode("402");
            }else if (Constant.http_status_not_found.equals(msg)){
                baseApi.setMsg(http_status_not_found);
                baseApi.setCode("404");
            }else if (Constant.http_status_method_not_allowed.equals(msg)){
                baseApi.setMsg(http_status_method_not_allowed);
                baseApi.setCode("405");
            }else if (Constant.http_status_internal_server_error.equals(msg)){
                baseApi.setMsg(http_status_internal_server_error);
                baseApi.setCode("500");
            }else if (Constant.http_status_not_implemented.equals(msg)){
                baseApi.setMsg(http_status_not_implemented);
                baseApi.setCode("501");
            }else if (Constant.http_status_bad_gateway.equals(msg)){
                baseApi.setMsg(http_status_bad_gateway);
                baseApi.setCode("502");
            }else if (Constant.http_status_service_unavailable.equals(msg)){
                baseApi.setMsg(http_status_service_unavailable);
                baseApi.setCode("503");
            }else if (Constant.http_status_gateway_timeout.equals(msg)){
                baseApi.setMsg(http_status_gateway_timeout);
                baseApi.setCode("504");
            }else if (Constant.no_login.equals(msg)){
                baseApi.setMsg(no_login);
                baseApi.setCode("1000");
            }else if (Constant.config_error.equals(msg)){
                baseApi.setMsg(config_error);
                baseApi.setCode("1001");
            }else if (Constant.user_exist.equals(msg)){
                baseApi.setMsg(user_exist);
                baseApi.setCode("1002");
            }else if (Constant.userpwd_not_exist.equals(msg)){
                baseApi.setMsg(userpwd_not_exist);
                baseApi.setCode("1003");
            }else if (Constant.error_add.equals(msg)){
                baseApi.setMsg(error_add);
                baseApi.setCode("308");
            }else if (Constant.error_update.equals(msg)){
                baseApi.setMsg(error_update);
                baseApi.setCode("309");
            }else if (Constant.error_delete.equals(msg)){
                baseApi.setMsg(error_delete);
                baseApi.setCode("310");
            }else {
                baseApi.setMsg(msg);
            }

        }
        return baseApi;
    }

    /**
     * 未登录
     * @param baseApi
     * @param msg
     * @param data
     * @return
     */
    public static BaseApi notLogin(BaseApi baseApi, String msg, Object data) {
        if (baseApi != null) {
            baseApi.setCode("401");
            if (StringUtils.isNotBlank(msg)) {
                baseApi.setMsg(msg);
            } else {
                baseApi.setMsg(NOTLOGIN);
            }
            if (data == null){
                baseApi.setRet("");
            }else {
                baseApi.setRet(data);
            }
        }
        return baseApi;
    }
    
    /**
     * @param baseApi 目标jsonobject
     * @param msg     成功信息
     * @param data    成功数据
     * @return 参数jsonObject
     * @discription 接口请求成功返回数据
     * @author mhy
     * @date 2018-09-26 15:16
     */
    public static BaseApi addRightData(BaseApi baseApi, String msg, Object data) {
        if (baseApi != null) {
            baseApi.setCode("200");
            if (StringUtils.isNotBlank(msg)) {
                baseApi.setMsg(msg);
            } else {
                baseApi.setMsg(SUCCESS);
            }
            if (data == null){
                baseApi.setRet("");
            }else {
                baseApi.setRet(data);
            }
        }
        return baseApi;
    }


    /**
     * @param baseApi
     * @param msg
     * @return
     * @author mhy
     * @date 2018-09-26 15:16
     */
    public static BaseApi addRightData( BaseApi baseApi , String msg ){
        if(baseApi != null){
            baseApi.setCode("200");
            if(StringUtils.isNotBlank(msg)){
                baseApi.setMsg(msg);
            }else{
                baseApi.setMsg(SUCCESS);
            }
        }
        return baseApi;
    }





    //接口报错后返回信息
//    public static final String SERVER_ERROR = "服务器异常，请稍后再试";
//    //接口查询数据为空
//    public static final String NO_RESULT = "无数据";
//    //接口查询数据成功
//    public static final String SUCCESS = "获取成功";
    //未登录
   // public static final String NOTLOGIN = "未登录";
    //未购买
    public static final String NOTBUG= "未购买";
    /**
     * @param baseApi
     * @param msg     错误信息
     * @return
     * @discription 添加失败信息
     * @author zhl
     * @date 2018/5/14 15:16
     */
//    public static BaseApi addFailMessage(BaseApi baseApi, String msg) {
//        if (baseApi != null) {
//            baseApi.setCode("400");
//            if (Constants.ERROR_NO_RESULT.equals(msg)) {
//                baseApi.setMsg(NO_RESULT);
//            } else if (Constants.ERROR_SERVER.equals(msg)) {
//                baseApi.setMsg(SERVER_ERROR);
//            } else {
//                baseApi.setMsg(msg);
//            }
//        }
//        return baseApi;
//    }

    /**
     * @param baseApi 目标jsonobject
     * @param msg     成功信息
     * @param data    成功数据
     * @return 参数jsonObject
     * @discription 接口请求成功返回数据
     * @author pwj
     * @date 2016/7/25 11:37
     */
//    public static BaseApi addRightData(BaseApi baseApi, String msg, Object data) {
//        if (baseApi != null) {
//            baseApi.setCode("200");
//            if (StringUtils.isNotBlank(msg)) {
//                baseApi.setMsg(msg);
//            } else {
//                baseApi.setMsg(SUCCESS);
//            }
//            if (data == null){
//                baseApi.setRet("");
//            }else {
//                baseApi.setRet(data);
//            }
//        }
//        return baseApi;
//    }

//    public static BaseApi notLogin(BaseApi baseApi, String msg, Object data) {
//        if (baseApi != null) {
//            baseApi.setCode("401");
//            if (StringUtils.isNotBlank(msg)) {
//                baseApi.setMsg(msg);
//            } else {
//                baseApi.setMsg(NOTLOGIN);
//            }
//            if (data == null){
//                baseApi.setRet("");
//            }else {
//                baseApi.setRet(data);
//            }
//        }
//        return baseApi;
//    }
    public static BaseApi notBuy(BaseApi baseApi, String msg, Object data) {
        if (baseApi != null) {
            baseApi.setCode("206");
            if (StringUtils.isNotBlank(msg)) {
                baseApi.setMsg(msg);
            } else {
                baseApi.setMsg(NOTBUG);
            }
            if (data == null){
                baseApi.setRet("");
            }else {
                baseApi.setRet(data);
            }
        }
        return baseApi;
    }
    /**
     * @discription  接口请求成功返回数据（重载）
     * @author pwj
     * @date 2016/9/6 10:23
     * @param baseApi
     * @param msg
     * @return
     */
//    public static BaseApi addRightData( BaseApi baseApi , String msg ){
//        if(baseApi != null){
//            baseApi.setCode("200");
//            if(StringUtils.isNotBlank(msg)){
//                baseApi.setMsg(msg);
//            }else{
//                baseApi.setMsg(SUCCESS);
//            }
//        }
//        return baseApi;
//    }



}
