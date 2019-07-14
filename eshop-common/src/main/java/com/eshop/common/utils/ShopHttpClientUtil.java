package com.eshop.common.utils;

import org.apache.http.client.methods.HttpPost;

public class ShopHttpClientUtil {
    public static HttpPost getHttpPost(String url){
        HttpPost httpPost = new HttpPost(url);
        return httpPost;
    }
}
