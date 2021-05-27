package com.avengers.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class TestDate {
	public static  void main(String[] args) throws ParseException {
//		System.out.println(TestDate.dateTostamp("2020-03-22T09:01:29Z"));
//		System.out.println(TestDate.stampToDate(1584867689000L));
		TestDate.getSplit("2020-01-01 00:00:00","2020-01-02 00:00:00",23);
	}

	public static  long mongoDateTostamp(String time) throws ParseException {
		String strDateFormate = "yyyy-MM-dd'T'HH:mm:ss'Z'";
		DateFormat df =new SimpleDateFormat(strDateFormate);
		df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Date parse = df.parse(time);
		long resultdate =  parse.getTime() + (8*60*60*1000);
		return resultdate;
	}


	public static  String stampToDate(long stamp) throws ParseException {
		String strDateFormate = "yyyy-MM-dd HH:mm:ss";
		DateFormat df =new SimpleDateFormat(strDateFormate);
		df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Date d = new Date(stamp);

		return df.format(d);
	}

	public static long dateTostamp(String time) throws ParseException {
		String strDateFormate = "yyyy-MM-dd HH:mm:ss";
		DateFormat df =new SimpleDateFormat(strDateFormate);
		df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Date parse = df.parse(time);
		long resultdate =  parse.getTime();
		return resultdate;
	}

	public static List<String> getSplit(String beginTime,String endTime,int splits) throws ParseException {
		List<String> splitList = new ArrayList<String>();

		long beginLong = TestDate.dateTostamp(beginTime);
		long endLong = TestDate.dateTostamp(endTime);
		Long interval = (endLong -beginLong) /splits;
		Long firstTime = beginLong;
		Long secondTime = 0L;
		for(int i= 1;i<=splits;i++) {
			secondTime = beginLong + (interval*i);
			splitList.add("select * from where update_time > ="+TestDate.stampToDate(firstTime)+" and update_time < "+TestDate.stampToDate(secondTime));
			System.out.println("select * from where update_time > ="+TestDate.stampToDate(firstTime)+" and update_time < "+TestDate.stampToDate(secondTime));
			firstTime  =  secondTime;
		}
		//如果没有分完最后的时间放到最后一组
		if((splits*interval)+beginLong< endLong){
			splitList.add("select * from where update_time > ="+TestDate.stampToDate(((splits*interval)+beginLong))+" and update_time < "+TestDate.stampToDate(endLong));
			System.out.println("select * from where update_time > ="+TestDate.stampToDate(((splits*interval)+beginLong))+" and update_time < "+TestDate.stampToDate(endLong));
		}

		return splitList;
	}











}
