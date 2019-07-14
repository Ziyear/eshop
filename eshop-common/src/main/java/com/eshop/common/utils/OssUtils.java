package com.eshop.common.utils;

import com.eshop.common.config.CloudStorageConfig;
import com.eshop.common.exception.BIZException;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.DefaultGenerateStorageClient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 日期处理
 */
public class OssUtils {

    /**
     * 云存储配置信息
     */
    private CloudStorageConfig config;

    private static DefaultGenerateStorageClient defaultGenerateStorageClient;

    static {
        defaultGenerateStorageClient = (DefaultGenerateStorageClient) SpringContextUtils.getBean("defaultGenerateStorageClient");
    }

    public OssUtils(CloudStorageConfig config) {
        this.config = config;
    }


    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }


    public String upload(InputStream inputStream, String suffix) {
        StorePath storePath;
        try {
            storePath = defaultGenerateStorageClient.uploadFile("group1", inputStream, inputStream.available(), suffix);
        } catch (Exception e) {
            throw new BIZException("上传文件失败，" + e.getMessage(), e);
        }

        return config.getFastdfsDomain() + "/" + storePath.getPath();
    }


    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, suffix);
    }


    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, suffix);
    }

}
