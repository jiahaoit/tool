package com.hao.random;

import java.util.Random;
import java.util.UUID;

/**
 * 生成可控制位数的随机数字和字母混合序列码
 * @author hao
 *
 */
public class StringRandom {

	/**
	 * 可控制位数：生成随机数字和字母混合编码
	 * @param length 生成几位数的序列码，不保证唯一
	 * @return
	 */
	public static String getStringRandom(int length) {

		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static void main(String[] args) {
		// 测试
		System.out.println(StringRandom.getStringRandom(8));
		System.out.println(StringRandom.getUUID());
	}
}
