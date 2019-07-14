package com.eshop.common.utils;

/**
 * 常量
 */
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;
    /**
     * 数据权限过滤
     */
    public static final String SQL_FILTER = "sql_filter";


    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),

        Menu(2),
        /**
         * 按钮
         */
        BUTTON(3);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3),
        /**
         * FASTDFS
         */
        FASTDFS(4),
        /**
         * 本地
         */
        LOCAL(5);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 短信服务商
     */
    public enum SmsService {
        /**
         * 阿里云
         */
        ALIYUN(1),
        /**
         * 腾讯云
         */
        QCLOUD(2);

        private int value;

        SmsService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 登录日志状态
     */
    public enum LoginLogStatus {
        /**
         * 登录成功
         */
        SUCCESS(0),
        /**
         * 登录失败
         */
        FAIL(1),
        /**
         * 账号已锁定
         */
        LOCK(2);

        private int value;

        LoginLogStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 接口数据错误类型
     */
    public static final String ERROR_NO_RESULT = "noresult";        //无结果
    public static final String ERROR_SERVER = "servererror";        //服务器异常

    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "FAIL";
    public static final String error_invalid_argument = "error_invalid_argument";
    public static final String error_pic_file = "error_pic_file";
    public static final String error_pic_upload = "error_pic_upload";
    public static final String error_record_not_found = "error_record_not_found";
    public static final String error_search_failed = "error_search_failed";
    public static final String error_duplicated_data = "error_duplicated_data";
    public static final String error_unknown_database_operation = "error_unknown_database_operation";
    public static final String error_file_download = "error_file_download";
    public static final String error_file_upload = "error_file_upload";

    //100-511为http 状态码
    // --- 4xx Client Error ---
    public static final String http_status_bad_request = "http_status_bad_request";
    public static final String http_status_unauthorized = "http_status_unauthorized";
    public static final String http_status_payment_required = "http_status_payment_required";
    public static final String http_status_forbidden = "http_status_forbidden";
    public static final String http_status_not_found = "http_status_not_found";
    public static final String http_status_method_not_allowed = "http_status_method_not_allowed";

    // --- 5xx Server Error ---
    public static final String http_status_internal_server_error = "http_status_internal_server_error";
    public static final String http_status_not_implemented = "http_status_not_implemented";
    public static final String http_status_bad_gateway = "http_status_bad_gateway";
    public static final String http_status_service_unavailable = "http_status_service_unavailable";
    public static final String http_status_gateway_timeout = "http_status_gateway_timeout";

    //1000以内是系统错误，
    public static final String no_login = "no_login";
    public static final String config_error = "config_error";
    public static final String user_exist = "user_exist";
    public static final String userpwd_not_exist = "userpwd_not_exist";
    public static final String error_add = "error_add";
    public static final String error_update = "error_update";
    public static final String error_delete = "error_delete";
}
