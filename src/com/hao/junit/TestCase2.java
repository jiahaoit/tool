package com.hao.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * 测试TestSuite用，和TestCase1一样。
 * @author hao
 *
 */
public class TestCase2 {

	@Before
    public void before() {
        System.out.println("测试前的准备工作，比如链接数据库等等");
    }
    @After
    public void after() {
        System.out.println("测试结束后的工作，比如关闭链接等等");
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
