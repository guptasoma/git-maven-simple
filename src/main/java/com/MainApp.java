package com;

public class MainApp {	
	public int addition(int a, int b) {
		return a+b;
	}
	
	public int multiply(int a, int b) {
		return a*b;
	}

	public static void main(String[] args) {
		MainApp map=new MainApp();
		System.out.println(map.addition(8, 6));
	}

}
