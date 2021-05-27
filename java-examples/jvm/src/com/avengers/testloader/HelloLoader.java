package com.avengers.testloader;

public class HelloLoader {

	public void print() {
		System.out.println(Thread.currentThread().getContextClassLoader());
		System.out.println("i am adfdploader");
	}
}
