package com.avengers.testloader;

public class FindClassOrder {

	public static void main(String[] args) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//		classloader.loadClass("");
		System.out.println(Thread.currentThread().getContextClassLoader());
		HelloLoader loader = new HelloLoader();
		loader.print();
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println(String.format("plugin.%s.%s","a","b"));
	}
}
