package com.hao.util;

import org.junit.Test;

/**
 * Assert 断言的使用方法
 * @author hao
 *
 */
public class AssertTests {

	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		// 查看两个数组是否相等。
		org.junit.Assert.assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		// 查看两个对象是否相等。类似于字符串比较使用的equals()方法
		org.junit.Assert.assertEquals("failure - strings not same", 5l, 5l);
	}

	@Test
	public void testAssertFalse() {
		// 查看两个对象是否不相等。
		org.junit.Assert.assertFalse("failure - should be false", false);
	}

	@Test
	public void testAssertNotNull() {
		// 查看对象是否不为空
		org.junit.Assert.assertNotNull("should not be null", new Object());
	}

	@Test
	public void testAssertNull() {
		// 查看对象是否为空
		org.junit.Assert.assertNull("should be null", null);
	}

	@Test
	public void testAssertNotSame() {
		// 查看两个对象的引用是否不相等。类似于使用“!=”比较两个对象
		org.junit.Assert.assertNotSame("should not be same Object", new Object(), new Object());
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		// 查看两个对象的引用是否相等。类似于使用“==”比较两个对象
		org.junit.Assert.assertSame("should be same", aNumber, aNumber);
	}

}
