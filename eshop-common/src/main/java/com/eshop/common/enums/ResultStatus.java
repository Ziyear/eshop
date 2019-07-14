package com.eshop.common.enums;

/**
 * RestApi状态码
 */
public enum ResultStatus {

    // 数据错误
    FAIL(-1, "common fail"),
    SUCCESS(200, "success"),
    error_invalid_argument(100, "参数不合法"),
    error_pic_file(300, "非法图片文件"),
    error_pic_upload(301, "图片上传失败"),
    error_record_not_found(302, "没有找到对应的数据"),
    error_search_failed(303, "查询失败"),
    error_duplicated_data(304, "数据已存在"),
    error_unknown_database_operation(305, "未知数据库操作失败，请联系管理员解决"),
    error_file_download(306, "文件下载失败"),
    error_file_upload(307, "文件上传失败"),
    error_add(308, "新增失败"),
    error_update(309, "修改失败"),
    error_delete(310, "删除失败"),
    error_excel(311, "Excel文件不能为空"),
    //100-511为http 状态码
    // --- 4xx Client Error ---
    http_status_bad_request(400, "Bad Request"),
    http_status_unauthorized(401, "Unauthorized"),
    http_status_payment_required(402, "Payment Required"),
    http_status_forbidden(403, "Forbidden"),
    http_status_not_found(404, "Not Found"),
    http_status_method_not_allowed(405, "Method Not Allowed"),

    // --- 5xx Server Error ---
    http_status_internal_server_error(500, "系统错误"),
    http_status_not_implemented(501, "Not Implemented"),
    http_status_bad_gateway(502, "Bad Gateway"),
    http_status_service_unavailable(503, "Service Unavailable"),
    http_status_gateway_timeout(504, "Gateway Timeout"),

    //1000以内是系统错误，
    no_login(1000, "没有登录"),
    config_error(1001, "参数配置表错误"),
    user_exist(1002, "用户名已存在"),
    userpwd_not_exist(1003, "用户名不存在或者密码错误");


    private int code;
    private String msg;

    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getErrorCode() {
        return code;
    }

    public String getErrorMsg() {
        return msg;
    }
}
