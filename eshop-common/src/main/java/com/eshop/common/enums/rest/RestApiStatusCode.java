package com.eshop.common.enums.rest;


import lombok.Getter;

/**
 * RestApi状态码
 */
@Getter
public enum RestApiStatusCode {
    /**
     * 会员id 仅用于front
     */
    USER_ID(101L,"userId"),
    /**
     * 正常 - 状态码：200
     * **/
    IS_OK(1101L,"200"),
    /**
     * 200 对应的msg
     */
    IS_OK_MEG(1201L,"获取数据成功"),
    /**
     * 语义错误，坏的请求 - 状态码：400
     * **/
    BAD_REQUEST(1102L,"400"),
    /**
     * 400 对应的msg
     */
    BAD_REQUEST_MSG(1202L,"未获取到数据"),

    /**
     * 请求权限错误，不能验证 - 状态码：401
     * **/
    UNAUTHORIZED(1103L,"401"),
    /*
     * 401 对应的msg
     */
    UNAUTHORIZED_MSG(1203L,"未获取到用户信息，请重新登陆"),
    /**
     * 服务器拒绝执行 - 状态码：403
     * **/
    FORBIDDEN(1104L,"403"),
    /**
     * 资源未找到 - 状态码：404
     * **/
    NOT_FOUND(1105L,"404"),
    /**
     * 内部服务错误 - 状态码：500
     * **/
    INTERNAL_SERVER_ERROR(1106L,"500"),
    /**
     * 500 对应的msg
     */
    INTERNAL_SERVER_ERROR_MEG(1206L,"服务器异常"),
    /**
     * 未知错误 - 状态码：-100
     * **/
    INTERNAL_UNKNOWN_ERROR(1107L,"-100"),
    /**
     * 请求参数错误 - 状态码：600
     * **/
    REQUEST_UNPARAMETER(1108L,"600"),;

    private Long id;
    private String statusCode;

    RestApiStatusCode(Long id, String statusCode) {
        this.id = id;
        this.statusCode = statusCode;
    }

}
