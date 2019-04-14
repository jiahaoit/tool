package com.hao.util;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * 了解一个测试类单元测试的执行顺序为：
 * @BeforeClass –> @Before –> @Test –> @After –> @AfterClass
 * @author hao
 *
 */
public class TestJunit1 {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("--------- in BeforeClass ----------");
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("---------- in AfterClass ----------");
	}
 
	@Before
	public void before() {
		System.out.println("in Before");
	}
 
	@After
	public void after() {
		System.out.println("in After");
	}
 
	@Test(timeout = 10000)
	public void testadd() {
		TestJunit2 a = new TestJunit2();
		assertEquals(6, a.add(3, 3));
		System.out.println("in Test ---- Add");
	}
 
	@Test
	public void testdivision() {
		TestJunit2 a = new TestJunit2();
		assertEquals(3, a.division(6, 2));
		System.out.println("in Test ---- Division");
	}
 
	@Ignore
	@Test
	public void test_ignore() {
		TestJunit2 a = new TestJunit2();
		assertEquals(6, a.add(1, 5));
		System.out.println("in test_ignore");
	}
 
	@Test
	public void teest_fail() {
		fail();
	}
}
class TestJunit2 extends Thread {
	 
	int result;
 
	public int add(int a, int b) {
		try {
			sleep(1000);
			result = a + b;
		} catch (InterruptedException e) {
		}
		return result;
	}
 
	public int division(int a, int b) {
		return result = a / b;
	}
}
