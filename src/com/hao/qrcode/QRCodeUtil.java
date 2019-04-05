package com.hao.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

public class QRCodeUtil {

	/**
	 * 把字符串写进二维码，并且生成图片到filePath
	 * 
	 * @param data
	 *            二维码信息
	 * @param destFile
	 *            生成二维码图片的保存路径
	 * @param logoPath
	 *            二维码中央logo路径
	 * @throws IOException
	 */
	public static void qrCodeEncode(String data, String filePath) throws IOException {
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M'); // 纠错级别（L 7%、M 15%、Q 25%、H 30%）和版本有关
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(7); // 设置Qrcode包的版本

		byte[] d = data.getBytes("GBK"); // 字符集 如果出现中文扫描乱码情况，请更换UTF-8 字符集
		BufferedImage bi = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
		// createGraphics // 创建图层
		Graphics2D g = bi.createGraphics();

		g.setBackground(Color.WHITE); // 设置背景颜色（白色）
		g.clearRect(0, 0, 139, 139); // 矩形 X、Y、width、height
		g.setColor(Color.BLACK); // 设置图像颜色（黑色）

		if (d.length > 0 && d.length < 123) {
			boolean[][] b = qrcode.calQrcode(d);
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (b[j][i]) {
						g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
					}
				}
			}
		}

		//放置二维码中央logo，但是不易调节位置，且影响二维码识别率，故此注释
//		if (logoPath != null) {
//			Image img = ImageIO.read(new File(logoPath));
//			g.drawImage(img, 25, 55, 60, 50, null);
//		}
		
		g.dispose(); // 释放此图形的上下文以及它使用的所有系统资源。调用 dispose 之后，就不能再使用 Graphics 对象
		bi.flush(); // 刷新此 Image 对象正在使用的所有可重构的资源

		File qrFile = new File(filePath);
		ImageIO.write(bi, "png", qrFile);
		System.out.println("Input Encoded data is：" + data + "\n" + "Qr Code File Path:" + filePath);
	}

	/**
	 * 解析二维码，返回解析内容
	 * 
	 * @param imagePath 二维码图片地址
	 * @return
	 */
	public static String qrCodeDecode(String imagePath) {
		String decodedData = null;
		QRCodeDecoder decoder = new QRCodeDecoder();
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			decodedData = new String(decoder.decode(new J2SEImage(image)), "GBK");
			// System.out.println("Output Decoded Data is：" + decodedData);
		} catch (DecodingFailedException dfe) {
			System.out.println("Error: " + dfe.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decodedData;
	}

	// 继承了QRCodeImage类，读取一些图片数据
	static class J2SEImage implements QRCodeImage {
		BufferedImage image;

		public J2SEImage(BufferedImage image) {
			this.image = image;
		}

		public int getWidth() {
			return image.getWidth();
		}

		public int getHeight() {
			return image.getHeight();
		}

		public int getPixel(int x, int y) {
			return image.getRGB(x, y);
		}
	}

}
