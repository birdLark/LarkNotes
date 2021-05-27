package com.avengers.example;

public class JarLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		int a =100;
//		while (a<1000) {
//			try {
//				String pluginPath = "E:\\source\\DataX\\target\\datax\\datax\\plugin\\writer\\elasticsearchwriter";
//				JarLoader jarLoader = new JarLoader(new String[]{pluginPath});
//				// @formatter:off
//				Class<?> aClass = jarLoader.loadClass("com.alibaba.datax.plugin.writer.elasticsearchwriter.ESWriter$Job");
//				// @formatter:on
//				Object o = aClass.newInstance();
////				System.out.println(o);
////				Thread.sleep(5000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			a++;
//		}
		String pluginPath = "E:\\source\\DataX\\target\\datax\\datax\\plugin\\writer\\elasticsearchwriter";
		JarLoader jarLoader = new JarLoader(new String[]{pluginPath});
		Class<?> aClass = jarLoader.loadClass("com.alibaba.datax.plugin.writer.elasticsearchwriter.ESWriter$Job");
		Object o = aClass.newInstance();
		
	}
}