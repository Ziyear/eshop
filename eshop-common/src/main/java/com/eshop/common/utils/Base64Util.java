/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Base64Util
 * Author:   pc-20171125
 * Date:     2018/12/19 17:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.eshop.common.utils;

import org.springframework.web.multipart.MultipartFile;
//import sun.misc.BASE64Decoder;
//
//import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author pc-20171125
 * @create 2018/12/19
 * @since 1.0.0
 */
public class Base64Util {

    /**
     * Base64转成图片
     * @param base64
     * @return
     */
    public static MultipartFile base64ToMultipart(String base64) {
//        try {
//            String[] baseStrs = base64.split(",");
//
//            BASE64Decoder decoder = new BASE64Decoder();
//            byte[] b = new byte[0];
//            b = decoder.decodeBuffer(baseStrs[1]);
//
//            for(int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {
//                    b[i] += 256;
//                }
//            }
//            return new BASE64DecodedMultipartFile(b, baseStrs[0]);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
          return null;
    }
}