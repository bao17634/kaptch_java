package com.byr.kaptcha.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;


import com.byr.com.google.code.kaptcha.Producer;
import com.byr.com.google.code.kaptcha.util.Config;

/**
 * 功能说明：验证码生成工具类
 * 生成浏览器可以识别的图片
 * 使用场景
 * 在网站任意需要验证码的位置，通过ajax向后台发请求，生成图片填充到image标签即可
 *
 * @author:linghushaoxia 生成算法来自google公司的kaptcha, 进行了封装
 * @time:2016年3月2日下午8:02:23
 * @version:1.0
 */
public class KaptchaServiceUtil {
    /**
     * 功能说明:
     *
     * @param properties
     * @return String[]
     * 长度为2的数组
     * 0：验证码图片的base64编码
     * 1：验证码的文本字符
     * @time:2016年3月3日下午8:31:23
     * @author:linghushaoxia
     * @exception:
     */
    public static String[] geneValidateCode(Properties properties) {
        //生成的验证码结果
        String[] result = {"", ""};
        ImageIO.setUseCache(false);
        //初始化配置
        Config config = new Config(properties);
        Producer kaptchaProducer = config.getProducerImpl();
        StringBuffer imageBuffer = new StringBuffer();
        // 创建图像中的文本
        String capText = kaptchaProducer.createText();
        // create the image with the text
        BufferedImage bi = kaptchaProducer.createImage(capText);
        // write the data out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            long fielName = System.currentTimeMillis();
            //保存图片
            ImageIO.write(bi, "png", out);
            ImageIO.write(bi, "png", new File("imae_auto/" + capText + "_" + fielName + ".png"));
            //对图片进行base64编码，可以在浏览器中直接显示，可作为图片标签使用
            byte[] data = out.toByteArray();
            imageBuffer.append(data);
        } catch (IOException e) {
            System.out.println("生成验证码出现异常:" + e.getMessage());
            e.printStackTrace();
        }
        if (imageBuffer != null) {
            //将字符拼接在前面和append方法相反
            imageBuffer.insert(0, "data:image/jpeg;base64,");
            result[0] = imageBuffer.toString();
            result[1] = capText;
        }
        return result;
    }

    public static void main(String[] args) {
        KaptchaServiceUtil kaptchaServiceUtil = new KaptchaServiceUtil();
        //生成图片数量
        Integer image_count = 100;
        Integer i = 0;
        while (image_count > 0) {
            kaptchaServiceUtil.properties(System.currentTimeMillis());
            image_count--;
            if (image_count.equals(++i)) {
                System.out.println("生成" + (i + 1) + "张图片已完成");
            }
        }
    }

    public void properties(long currentTime) {
        //验证码的属性
        Properties properties = new Properties();
        //边框
        properties.put("kaptcha.border", "no");
        //边框为绿色
        properties.put("kaptcha.border.color", "green");
        //图片宽度
        properties.put("kaptcha.image.width", "300");
        //高度
        properties.put("kaptcha.image.height", "60");
        //字符数量
        properties.put("kaptcha.textproducer.char.length", "5");
        //字体大小
        properties.put("kaptcha.textproducer.font.size", "55");
        //干扰视线类
        properties.put("kaptcha.noise.impl", "com.byr.com.google.code.kaptcha.impl.DefaultNoise");
        //字符间隔
        properties.put("kaptcha.textproducer.char.space", "1");
        //字体
//        properties.put("kaptcha.textproducer.font.names","Arial");
        //噪声颜色
        properties.put("kaptcha.noise.color", "red");
        //字体颜色
        properties.put("kaptcha.textproducer.font.color", "red");
        /**
         * 图片样式：<br />水纹 com.byr.com.google.code.kaptcha.impl.WaterRipple <br />
         * 鱼眼 com.byr.com.google.code.kaptcha.impl.FishEyeGimpy <br />
         * 阴影 com.google.code.kaptcha.impl.ShadowGimpy
         */
        if (currentTime % 2 == 0) {
            properties.put("kaptcha.obscurificator.impl", "com.byr.com.google.code.kaptcha.impl.ShadowGimpy");
        }
        if (currentTime % 3 == 0) {
            properties.put("kaptcha.obscurificator.impl", "com.byr.com.google.code.kaptcha.impl.FishEyeGimpy");
        } else {
            properties.put("kaptcha.obscurificator.impl", "com.byr.com.google.code.kaptcha.impl.WaterRipple");
        }
        //背景颜色渐变开始
        properties.put("kaptcha.background.clear.from", "255,193,37");
        //背景颜色渐变结束
        properties.put("kaptcha.background.clear.to", "255,193,37");

        geneValidateCode(properties);
    }
}
