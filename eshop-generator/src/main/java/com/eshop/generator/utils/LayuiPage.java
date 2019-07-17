package com.eshop.generator.utils;

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
    private int code = 0;
    private long count;
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
