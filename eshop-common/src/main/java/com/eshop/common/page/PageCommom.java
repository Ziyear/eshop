package com.eshop.common.page;

/**
 * <p>Copyright © 2019 LOUIS. All rights reserved.</p>
 *
 * @ClassName: <p>PageCommom</p>
 * @Description: <p>分页处理共用代码部分</p>
 * @author: <p>291576222</p>
 * @date: <p>2019年4月3日08:45:09</p>
 * @version: <p>V1.0</p>
 */
public class PageCommom {

    /**
     * volatile变量保证可见性
     */
    private volatile static PageCommom instance = null;

    private PageCommom() {
        getInstance();
    }

    /**
     * 单例获取当前类实例
     */
    private static PageCommom getInstance() {
        if (instance == null) {
            synchronized (PageCommom.class) {
                if (instance == null) {
                    instance = new PageCommom();
                }
            }
        }
        return instance;
    }

    /**
     * 页码默认值
     */
    public static final Integer PAGE_NUM = 1;
    /**
     * 页大小默认值
     */
    public static final Integer PAGE_SZIE = 50;

    /**
     * @param pageNum 页大小
     * @return pageNum
     * @Title: <p>getPageNum</p>
     * @Description: <p>分页pageNum参数设置</p>
     * @date: <p>2019年4月3日14:12:50</p>
     */
    public static Integer getPageNum(Integer pageNum) {
        return (null == pageNum || 0 == pageNum) ? PAGE_NUM : pageNum;
    }

    /**
     * @param pageSize 页大小
     * @return pageSize
     * @Title: <p>getPageSize</p>
     * @Description: <p>分页pageSize参数设置</p>
     * @date: <p>2019年4月3日14:12:50</p>
     */
    public static Integer getPageSize(Integer pageSize) {
        return (null == pageSize || 0 == pageSize) ? PAGE_SZIE : pageSize;
    }

}
