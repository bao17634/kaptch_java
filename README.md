# kaptcha
</br>kaptcha验证码生成
</br>验证码生成工具,生成浏览器可以识别的图片字符串
</br>使用场景：
</br>在网站任意需要验证码的位置，通过ajax向后台发请求，生成图片填充到image标签即可
</br>使用方法：
</br>public static void main(String[] args) {
</br>		//验证码的属性
</br>		Properties properties = new Properties();
</br>		//边框
</br>		properties.put("kaptcha.border", "yes");
</br>		//边框为绿色
</br>		properties.put("kaptcha.border.color", "green");
</br>		//图片宽度
</br>		properties.put("kaptcha.image.width", "200");
</br>		//高度
</br>		properties.put("kaptcha.image.height", "50");
</br>		//字符数量
</br>		properties.put("kaptcha.textproducer.char.length", "4");
</br>		//字体大小
</br>		properties.put("kaptcha.textproducer.font.size", "40");
</br>		//字符间隔
</br>		properties.put("kaptcha.textproducer.char.space", "2");
</br>		//噪声颜色
</br>		properties.put("kaptcha.noise.color", "black");
</br>		//粘贴到浏览器，可以查看浏览器中的显示效果
</br>		String validateCode= KaptchaServiceUtil.geneValidateCode(properties);
</br>		System.out.println(validateCode);
</br>}
</br>说明：
</br>生成算法来自google公司的kaptcha,进行了封装。
