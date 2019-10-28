package com.byr.captch;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

/**
 * @ClassName: URLContent
 * @Description: TODO
 * @Author: yanrong
 * @Date: 2019/10/24 10:29
 * @Version: 1.0
 */
public class URLContent2 {

//    public static void main(String args[]){
//    URLContent urlContent=new URLContent();
//    long currentTime=System.currentTimeMillis();
//    String url="https://delivery.dhl.com/captcha?type=image&"+currentTime;
//    urlContent.getURLContent(url);
//    }


    public static void main(String[] args) throws Exception {
        System.out.println("开始");
        for (int i = 1; i <= 20000; i++) {
            long currentTime = System.currentTimeMillis();
            Thread.sleep(1000);
            String url = "https://delivery.dhl.com/captcha?type=image&" + currentTime;//一个随机图片接口
            getImg(url, currentTime);
            System.out.println("完成" + i);
        }

    }

    private static void getImg(String u, long currentTime) {
        URL url;
        try {
            url = new URL(u);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream in = conn.getInputStream();
            byte[] data = readInputStream(in);
            File f = new File("image1/" + currentTime + ".png");
            FileOutputStream out = new FileOutputStream(f);
            out.write(data);
            out.close();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }
    private static byte[] readInputStream(InputStream ins) throws IOException {
        // TODO 自动生成的方法存根
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = ins.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        ins.close();
        return out.toByteArray();
    }
}
