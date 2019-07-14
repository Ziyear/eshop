package com.eshop.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Layui分页
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0 2018-03-12
 */
@Data
public class LayuiPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "返回状态码；200:成功")
    private int code = 0;
    @ApiModelProperty(value = "总记录数")
    private long count;
    @ApiModelProperty(value = "列表数据")
    private List<?> data;

    public LayuiPage(List<?> data, long count) {
        this.data = data;
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
