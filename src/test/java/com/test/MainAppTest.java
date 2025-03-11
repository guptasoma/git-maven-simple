package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import com.MainApp;

public class MainAppTest {
	
	MainApp map=null;
	
	@Before
	public void before() {
		map=new MainApp();
	}
	
	@After
	public void after() {
		map=null;
	}
	
	@Test
	public void testWithPositive() {
		assertEquals(14,map.addition(7, 7));
	}
	
	@Test
	public void testWithNegative() {
		assertEquals(-12,map.addition(-6,-6));
	}

	@Test
	public void testWithPosNeg() {
		assertEquals(0,map.addition(-5, 5));
	}
	
	@Test 
	public void testMultiplyWithTwoPositive() {
		assertEquals(27,map.multiply(3,9));
	}
	
	@Test 
	public void testMultiplyWithTwoNegative() {
		assertEquals(27,map.multiply(-3,-9));
	}
	
}
