package com.byr.com.google.code.kaptcha.impl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.byr.com.google.code.kaptcha.NoiseProducer;
import com.byr.com.google.code.kaptcha.util.Configurable;

/**
 * The default implementation of {@link NoiseProducer}, adds a noise on an
 * image.
 */
public class DefaultNoise extends Configurable implements NoiseProducer
{
	/**
	 * 在图像上产生噪点。 噪声曲线取决于因子值。
	 *如果所有因素的值均大于1.0f，则看不到噪声
	 * 
	 * @param image
	 *            the image to add the noise to
	 * @param factorOne
	 * @param factorTwo
	 * @param factorThree
	 * @param factorFour
	 */
	public void makeNoise(BufferedImage image, float factorOne,
			float factorTwo, float factorThree, float factorFour)
	{
		Color color = getConfig().getNoiseColor();

		// image size
		int width = image.getWidth();
		int height = image.getHeight();

		// 线改变笔划和方向的点
		Point2D[] pts = null;
		Random rand = new Random();

		// 取点的曲线
		CubicCurve2D cc = new CubicCurve2D.Float(width * factorOne, height
				* rand.nextFloat(), width * factorTwo, height
				* rand.nextFloat(), width * factorThree, height
				* rand.nextFloat(), width * factorFour, height
				* rand.nextFloat());

		// 创建一个迭代器以定义展平曲线的边界
		PathIterator pi = cc.getPathIterator(null, 2);
		Point2D tmp[] = new Point2D[200];
		int i = 0;

		//当pi迭代曲线时，将点添加到tmp数组
		while (!pi.isDone())
		{
			float[] coords = new float[6];
			switch (pi.currentSegment(coords))
			{
				case PathIterator.SEG_MOVETO:
				case PathIterator.SEG_LINETO:
					tmp[i] = new Point2D.Float(coords[0], coords[1]);
			}
			i++;
			pi.next();
		}

		pts = new Point2D[i];
		System.arraycopy(tmp, 0, pts, 0, i);

		Graphics2D graph = (Graphics2D) image.getGraphics();
		graph.setRenderingHints(new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON));

		graph.setColor(color);

		// 最多3点更改行程和方向
		for (i = 0; i < pts.length - 1; i++)
		{
			if (i < 3)
				graph.setStroke(new BasicStroke(0.9f * (4 - i)));
			graph.drawLine((int) pts[i].getX(), (int) pts[i].getY(),
					(int) pts[i + 1].getX(), (int) pts[i + 1].getY());
		}

		graph.dispose();
	}
}
