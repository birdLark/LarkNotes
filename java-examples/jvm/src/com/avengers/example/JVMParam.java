package com.avengers.example;

import java.util.ArrayList;
import java.util.List;

public class JVMParam {

	public static void main(String[] args) {
//		byte[] b = null;
		List list = new ArrayList();
 		for(int i=0;i<25;i++) {
 			list.add(new byte[1*1024*1024]);
		}
	}
}
