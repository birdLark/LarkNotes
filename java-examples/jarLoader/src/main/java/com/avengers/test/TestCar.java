package com.avengers.test;

import com.avengers.example.JarLoader;

public class TestCar {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		String pluginPath = "E:\\test";
		JarLoader jarLoader = new JarLoader(new String[]{pluginPath});
		Class<? extends Car> clazz = (Class<? extends Car>) jarLoader.loadClass("com.avengers.test.BaoMaCar");
		Car car = clazz.newInstance();
		car.print();
	}
}
