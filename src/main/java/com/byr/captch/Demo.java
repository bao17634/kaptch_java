package com.byr.captch;

import com.byr.kaptcha.util.HttpUtils;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Byr
 * @date ：Created in 2019/10/28 23:28
 * @description：
 * @modified By：
 * @modified Date：
 * @version: $
 */
public class Demo {
    public static void main(String[] args) {
        String host = "http://apigateway.jianjiaoshuju.com";
        String path = "/api/v_1/fzyzm.html";
        String method = "POST";
        String appcode = "AB1653FC6E245A54764979DF040FF731";
        String appKey = "AKID2e3ba67272e0929056b515a9775eba43";
        String appSecret = "74687c8a5cae8af5efad102d0d62a092";
        Map headers = new HashMap();
        headers.put("appcode", appcode);
        headers.put("appKey", appKey);
        headers.put("appSecret", appSecret);
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map querys = new HashMap();
        Map bodys = new HashMap();
        bodys.put("v_pic", "图片base64加密后的字符串");
        bodys.put("v_type", "验证码类型");
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
