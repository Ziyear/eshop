package com.eshop.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class GetTokenUtils {


    /**
     * 获取token
     *
     * @param request
     * @return
     * @author mhy
     * @date 2018-12-04 14:05:18
     */
    public static String getToken(HttpServletRequest request) {
        String token = "";
        token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        return token;
    }
}

