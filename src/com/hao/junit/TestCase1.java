package com.hao.junit;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 初步使用Junit
 * @author hao
 *
 */
public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void testSum1() {
		int result = GeneralMain.sum1(5, 6);
		Assert.assertEquals(result, 11);
	}

	@Test
	public void testSum2() {
		int result = GeneralMain.sum2(1, 2, 3);
		Assert.assertEquals(result, 5);
	}
}
