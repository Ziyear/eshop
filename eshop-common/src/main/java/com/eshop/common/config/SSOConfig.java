package com.eshop.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * SSO单点登录配置信息
 *
 */

@Component
@Configuration
public class SSOConfig {

    /**
     * SSO单点登录client_id
     */
    @Value("${sso.client_id}")
    public String SSO_CLIENT_ID;
    /**
     * SSO单点登录client_secret
     */
    @Value("${sso.client_secret}")
    public String SSO_CLIENT_SECRET;
    /**
     * SSO获取令牌参数 目前固定
     */
    @Value("${sso.grant_type}")
    public String SSO_GRANT_TYPE;
    /**
     * SSO登录时重定向至认证中心的url参数
     */
    @Value("${sso.response_type}")
    public String SSO_RESPONSE_TYPE;
    /**
     * SSO当进行用户登录授权时该参数固定为user_info
     */
    @Value("${sso.scope}")
    public String SSO_SCOPE;
    /**
     * 获取令牌url
     */
    @Value("${sso.token_url}")
    public String SSO_TOKEN_URL;
    /**
     * 接口url
     */
    @Value("${sso.api_url}")
    public String SSO_API_URL;
    /**
     * SSO回调URL
     */
    @Value("${sso.redirect_url}")
    public String SSO_REDIRECT_URL;
    /**
     * SSO授权地址
     */
    @Value("${sso.authorize_url}")
    public String SSO_AUTHORIZE_URL;
    /**
     * SSO用户名
     */
    @Value("${sso.username}")
    public String SSO_USERNAME;
    /**
     * SSO密码
     */
    @Value("${sso.password}")
    public String SSO_PASSWORD;
    /**
     * 退出登录URL
     */
    @Value("${sso.logout_url}")
    public String SSO_LOGOUT_URL;
    /**
     * 判断是否登录
     */
    @Value("${sso.whether_login}")
    public String SSO_WHETHER_LOGIN;
    /**
     * 判断是否登录
     */
    @Value("${sso.user_login}")
    public String SSO_LOGIN;
    /**
     * 本地登陆:1  还是SSO登陆:2
     */
    @Value("${sso.login_status}")
    public String SSO_LOGIN_STATUS;
}