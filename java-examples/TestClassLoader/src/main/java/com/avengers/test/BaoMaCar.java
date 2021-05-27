package com.avengers.test;

import com.avengers.test.Car;

public class BaoMaCar extends Car {
	public void print() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		System.out.println("我是宝马!");
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<? extends Car> aClass = (Class<? extends Car>) classLoader.loadClass("com.avengers.test.BenChiCar");
		Car car = aClass.newInstance();
		car.print();
	}
}
