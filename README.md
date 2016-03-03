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
</br>data:image/jpeg;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a
</br>HBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy
</brMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAyAMgDASIA
</br>AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA
</br>AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3
</br>ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm
</br>p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA
</br>AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx
</br>BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK
</br>U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3
</br>uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDt7a2g
</br>a2iJhjJKAklR6VMLS3/594v++BSWn/HpD/1zX+VWBXNRo0/Zx91bLoceHw9J0o+6tl0XYiFpbf8A
</br>PvF/3wKeLO2/594v++BXEav4u1PTvihpXh8CAafdxqzEod5J3jrn1Udq70Vp7Gl/KvuNvq9H+Rfc
</br>iMWdr/z7Q/8AfApwsrX/AJ9of+/YqDUNV0/Sbfz9RvYLWL+9NIFz9M9a4u5+LFhPdfZPDmk6hrk4
</br>PzGCMqgHrnBP6Ae9HsaX8q+4Pq9H+RfcjvRZWn/PrD/37FOFjaf8+sH/AH7FcsPF+s/9CTq//fcX
</br>/wAVTh4w1n/oSdX/AO+4v/iqPY0v5V9wfV6P8i+5HUixtP8An1g/79inCws/+fSD/v2K5UeMNa/6
</br>EjWP++4v/iqcPGOtf9CPrH/fcX/xVHsaX8q+4Pq9H+Rfcjqhp9n/AM+kH/fsf4U4afZf8+dv/wB+
</br>x/hXIx/EWO2UnXPD2t6UoJzLJamWID/eTP8AKr8PxE8J3EXmQa1byD0BO7oTyuMgYHUjHIHUgUex
</br>pfyr7g+r0f5F9yOhGnWX/Pnb/wDfpf8ACnDTrH/nzt/+/S/4VDp2rWmpqTbs+4feV42QqfQhgCD3
</br>wecEZHNaAo9jS/lX3B9Xo/yL7kVxptj/AM+Vv/36X/CnDTbD/nytv+/S/wCFWBTxR7Gl/KvuD6vR
</br>/kX3IrjTLD/nxtv+/S/4U4aZYf8APjbf9+l/wqcsqDLMAPUmnjnpR7Gl/KvuD6vR/kX3IrjS9P8A
</br>+fG2/wC/K/4U4aXp/wDz4Wv/AH5X/CrIpwo9jS/lX3B9Xo/yL7kVhpWnf8+Fr/35X/CnDSdO/wCg
</br>fa/9+V/wq0KcKPY0v5V9wfV6P8i+5FUaTpv/AED7X/vyv+FOGkab/wBA+0/78r/hVoU8Uexpfyr7
</br>g+r0f5F9yMnVNL0+PSL10sLVXWByrCFQQQp5HFFXNW/5Al//ANe0n/oJor5jP4RjUhyq2h8bxPTh
</br>CrT5VbR/mcbaf8ekP/XNf5VYFQWn/HpD/wBc1/lVgV9PR/hR9EfZYf8Agw9F+R5D8ULiPSfiH4X1
</br>eUkRRbDIQMnakmT+jGku/Gnivx9cyad4QspbKxztkvHO1gPd+ifRctXWeJ/hppfirWjqd3dXMbm3
</br>8rZGRjcM7W59M9BjOPrTdL+GVna6bBZ32sateRxrgwrctFD+CL0/M1qbGHaeA/B/hyNbjxdrUN9f
</br>KAStxcbVX2CZ3N369fSt+38caZaQRpoHhnVbnTUOXmsrAxxKuOqggbvyFbWl+CPDWkTedZaPbJL2
</br>kcGRh9CxJB966EUAU9G1a113SLbU7Isbe4Xcm9cHrjkfUGtAVy/grTbzRrXU9LngaO1gv5WsmOMN
</br>C53jH0JYV0N61yljM1mivcBT5aseCaAEvdTsdMi82+u4bdPWRgKXT9W0/VUL2F5BcqOvlODivEp/
</br>DFl/aMmpfEfX/wDSXY+XZRy7nC9s46DGOBWJpOoWPh7x/bT+GryZ9MMg82JmIJUHBz6jnP4UAejf
</br>EzXtSscQ21vMUf5AQpGMnbgEHOW6A44BrjG+HGo6to0+rXEsQ2x5XGACcYwo/ujoOR3PPf3zZbX9
</br>updY5o85GRkZB/xFcH8SvEmm+GfDbWFvHB9omUrFGAMr2JH4MR680AeQ/DbT7y58ZpZW+o3mnsyk
</br>efayAfTPUMDjpXtWor448MWMl4Nf0vVbWLG77faGFwCQPvRnHfqRWJ8JPCt9BZyeIb8ypc3h3Ikh
</br>I3J15B9eMMc4HQc5qv431v8At69TRftkEUnnoDAyt+8AByP9nJJHPUGgDPt/jhqy6q1vcaNHIMsu
</br>y2ff06kcc4wfwrt7j4u+GodMklSeQX6puSzngeJ2PYfMMfka8r8XaLDoWq+FYbNHEcaxrcYTacsc
</br>gMPUpkH6GvoOTS9O1bTIoL6ytbu32jak0SuuMcEZ9qAPG38JeO/iBFPrOpaq+mWbAva2pdh8vUfK
</br>OB9TzS/BzxTqtt4quPC2ozvPEFcpvOdrLgdfTA6Ve8a+FfEXhu6RfAEWowWMsbC4t4py8QY/3UfI
</br>HHpXGfDHWrfQPFdzcapo+o3eoIGDvb4kdB0bMfBOMdQT9KAPqAU4VhaF4u0DxIv/ABKtTgnlH3oS
</br>dkq/VGww/Kt0UAOFPFNFOFADhThSCnCgCpq//IEv/wDr3k/9BNFLq/8AyBL/AP69pP8A0E0V8rxD
</br>/Fh6HxXFP8an6P8AM420/wCPOD/rmv8AKrAqC0/484P+ua/yqwK+lo/wo+iPr8P/AAYei/IcKcKa
</br>KeK1NhwpwpopwoAcKyvE+pTaR4cvL22VWnjTKK3Qn/8AVmtYUy5tYry1ktp0DxSKVZT3BoA+dfAe
</br>qeGPtV5qni2Y3N6WOwT7nzwMEe/DA56cYqr4o1nQ73xTa6hoelhbSF0DKybVlIJPboDkA+mBXsq/
</br>CfwmLyS5NiWLuXKlyVGQMjH1GfxPatW+8CeHr/Shpx0+OGFTlTENpXscH3BI/wDrgGgCjeeM7LRv
</br>A6ah9rFzOsCDfsCl3IxuK9snJI9QRXimjSDxf4un1rX5ithFL5rru2qcsAEDHgHGOvJ24616Zrnw
</br>kE+hxaZpl9MltCd4jd925yMMcEcdjwcdeBwRi6d8ELmNik984RxtcJJsHUgsDg7hj+EgE9yBwQDr
</br>dO+Kehy69ZaDaW0itI3l/uzEY0z0+ZHIP0GevWoPHXw2XVLmbVNNk+zzBAUhjACtMW+aRz3G09Pb
</br>r2OxoXw30nSZorxVdLsMHk2eWQxHQZEa4GOyhR7V2kkSTRNFIoZGGCD3FAHzH4ruvE9nfWMNzMl1
</br>HDcgWt4EAEpQBFDEEjABJ6n755PBr1X4a6xrFt4dMviKTyrG1hVIGcYyOeD/AHiFRcEeprN8S/CG
</br>81C4un0/U2jhnLMLfokajJVFBz1OPQDHfPG54N8A6npFjNY61qJvrKaBYmgdyQq7TuUD6kc9tvua
</br>AJP+F0+DArn7bMSp4AiPzfSvH9I1Zte+M1hqWmRPFC91HIUVewwzj8Tu/MV7NH8HfByTGUWDkls4
</br>MhI/L8vyro9F8HaBoD+ZpumwwyZyHC5I4xwfpQAmt+DPD3iQiXUdMie4HK3MeY5lPYh1wePrWMPD
</br>3jLw982g+IV1a1XpZa0Nzgf7M6859NwxXcCnigDiIviRDp0i2/izR77w/MTtE0y+dbMf9mZOPzAr
</br>s7K+tNRtkubG6huYH+7LDIHU/QjipHijmjaOVFeNhhlYZBHoRXIXnwz0Y3TXuhzXfh+/bkzaZJ5a
</br>Mf8Aaj+4R7YFAHainiuV8Pw+M7HUvsmt3Wm6np2wlb6JDDPuGMBo+V59j2rqhQBU1f8A5Al//wBe
</br>0n/oJopdX/5Al/8A9e0n/oJor5XiH+LD0PiuKf41P0f5nlQubhQAs8gA4ADnil+13P8Az8S/99mi
</br>iqh8KLp/AvQPtlz/AM/M3/fZpftl1/z8zf8AfZooqyg+23X/AD8zf9/DR9tu/wDn6m/7+GiigBft
</br>13/z9T/9/DR9uvP+fuf/AL+GiigA+33n/P3P/wB/DR/aF7/z9z/9/D/jRRQAv9oXv/P5cf8Af1v8
</br>aP7Rvf8An8uP+/rf40UUAH9o33/P5cf9/W/xpf7Svv8An9uf+/rf40UUAH9pX/8Az+3P/f1v8aP7
</br>Tv8A/n+uf+/rf40UUAL/AGnqH/P9c/8Af5v8aP7U1D/n/uv+/wA3+NFFAB/auo/8/wDdf9/m/wAa
</br>P7V1H/n/ALr/AL/N/jRRQAv9raj/ANBC6/7/ADf40f2tqX/QQu/+/wA3+NFFAB/a+pf9BC7/AO/z
</br>f40v9r6n/wBBG7/7/t/jRRQA19V1GRGR7+6ZGBDK0zEEeh5ooorysw+KJ4ua/HH0P//Z
</br>}
</br>说明：
</br>生成算法来自google公司的kaptcha,进行了封装。
