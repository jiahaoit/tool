package com.hao.qrcode;
import java.io.IOException;

public class QRCodeTest {

	public static void main(String[] args) {
		// 二维码内容
		String data = "微信搜索公众号：浩Coding";
		String filePath = "/home/hao/Desktop/1.png";
//		String logoPath = "/home/hao/Desktop/logo.png";
		// File qrFile = new File(filePath);

		try {
//			QRCodeUtil.qrCodeEncode(data, filePath, logoPath);
			QRCodeUtil.qrCodeEncode(data, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 解码
		String reText = QRCodeUtil.qrCodeDecode(filePath);
		System.out.println(reText);
	}

}
