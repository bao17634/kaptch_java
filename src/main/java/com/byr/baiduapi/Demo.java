package com.byr.baiduapi;

import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.ocr.AipOcr;
import com.baidu.aip.util.Util;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：Byr
 * @date ：Created in 2019/10/26 18:34
 * @description：
 * @modified By：
 * @modified Date：
 * @version: $
 */
public class Demo {
    //设置APPID/AK/SK
    public static final String APP_ID = "17626002";
    public static final String API_KEY = "6oP0vBEegQpc8NNVdN4NlN5L";
    public static final String SECRET_KEY = "SrzObMDXuv7nUydBj16EARFVp7Q69UvQ";

    //
    public static void main(String[] args) throws IOException, InterruptedException {
        Demo demo = new Demo();
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
//        String image = "C:\\Users\\rong\\Desktop\\image";
        String image = "G:\\PythonObject\\cnn_captcha\\sample\\test";
//        while (true) {
        File file1 = new File(image);
        File[] fs = file1.listFiles();
        if (fs.length == 0) {
            System.out.println("等待");
            Thread.sleep(1000);
        }
        //遍历File[]数组
        for (File f : fs) {
            if (!f.isDirectory()) {
//                System.out.println(f);
//                    boolean is = demo.sample(client, f.toString());
                int index = f.getName().trim().indexOf("_");
                if (demo.check(f.getName().substring(0, index)) || index != 5) {
                    System.out.println("1111:" + f);
//                    boolean is = demo.savePic(new FileInputStream(f), f.getName().trim(), f.getName().trim());
                }
//                long time = System.currentTimeMillis();
//                String fileName=f.getName().substring(0,f.getName().indexOf("."))+"_"+time+".png";
//                boolean is = demo.savePic(new FileInputStream(f), fileName, f.getName().substring(0,f.getName().indexOf(".")));
//                    if (is){
//                        f.delete();
//                    }
            }
        }
//        }

    }

    public boolean check(String str) {
        char[] srChar = str.toCharArray();
        for (char c : srChar) {
            if ((char) c >= 'A' && (char) c <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public boolean sample(AipOcr client, String imagePath) throws IOException {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        try {
            byte[] file = Util.readFileByBytes(imagePath);
            org.json.JSONObject res = client.basicAccurateGeneral(file, options);
            if (res.toString().indexOf("words_result") == -1) {
                return false;
            }
            JSONArray jo = JSONArray.parseArray(res.get("words_result").toString());
            if (jo == null || jo.size() == 0) {
                return false;
            }
            String fileName = JSONObject.parseObject(jo.get(0).toString()).get("words").toString();
            File file1 = new File(imagePath);
            //遍历path下的文件和目录，放在File数组中
            String imageName = fileName + "_" + file1.getName();
            boolean is = savePic(new FileInputStream(file1), imageName, file1.getName());
            return is;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean savePic(InputStream inputStream, String fileName, String oldName) {
        OutputStream os = null;
        System.out.println("保存:{}" + fileName);
        try {
            String path = "G:\\PythonObject\\cnn_captcha\\sample\\origin";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            if (isSpecialChar(fileName)) {
                os = new FileOutputStream(tempFile.getPath() + File.separator + oldName);
            } else {
                os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            }
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
