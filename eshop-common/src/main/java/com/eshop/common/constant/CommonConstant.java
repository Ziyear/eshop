package com.eshop.common.constant;

public class CommonConstant {
    private CommonConstant(){}

    /**
     * 请求响应成功Code
     */
    public static final String RESULT_SUCCESS = "200";
    /**
     * 服务器异常Code
     */
    public static final String RESULT_FAILED = "500";
    /**
     * 保留小数位数:5
     */
    public static final int SCALE_FIVE = 5;
    /**
     * 保留小数位数:2
     */
    public static final int SCALE_TWO = 2;

    /**
     * 卖家端
     */
    public static final String FRONT_FLAG = "1";
    /**
     * 买家端
     */
    public static final String WAP_FLAG = "2";
    /**
     * 平台
     */
    public static final String ADMIN_FLAG = "3";

    //审核状态1.审核中 2.已通过
    public static final String AUDIT_STATUS_IN_REVIEW="1";
    public static final String AUDIT_STATUS_FINISH="2";
    public static final Integer VALID_STATE=0;
    public static final Integer INVALID_STATE=1;
}
