package com.hao.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
/**
 * 使用TestSuite，多个测试类一起测试
 * @author hao
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCase1.class,TestCase2.class})
public class TestSuite {
 
}
