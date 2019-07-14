package com.eshop.common.config;


import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 云存储配置信息
 */
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    //FastDFS绑定的域名
    @NotBlank(message = "FastDFS绑定的域名不能为空")
    @URL(message = "FastDFS绑定的域名格式不正确")
    private String fastdfsDomain;

    public String getFastdfsDomain() {
        return fastdfsDomain;
    }

}
