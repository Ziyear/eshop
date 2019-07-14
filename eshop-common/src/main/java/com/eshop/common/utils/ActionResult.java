package com.eshop.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class ActionResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ActionResult() {
        put("code", "200");
        put("msg", "success");
    }

    public static ActionResult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ActionResult error(String msg) {
        return error(500, msg);
    }

    public static ActionResult error(int code, String msg) {
        ActionResult r = new ActionResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ActionResult ok(String msg) {
        ActionResult r = new ActionResult();
        r.put("msg", msg);
        return r;
    }

    public static ActionResult ok(Map<String, Object> map) {
        ActionResult r = new ActionResult();
        r.putAll(map);
        return r;
    }

    public static ActionResult ok() {
        return new ActionResult();
    }

    @Override
    public ActionResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
