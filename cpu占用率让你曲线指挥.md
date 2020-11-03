第一题(11月3日)

 写一个程序,让用户来决定windows任务管理器的cpu占用率。程序越简单越好，计算机语言不限。
1.cpu的占用率固定在50%，为一条直线；
2.cpu的占用为一条直线
3.cpu的占用状态为一条正弦曲线。 



**解题思路:**

要操纵cpu的使用曲线，就需要使cpu在一段时间内跑busy和idle两个不同的循环，从而通过不同的时间比例，来调节cpu使用率。

busy 空循环来实现，idle可以通过sleep来实现

**window常用的函数:**

sleep() 休眠

getTickCount() 获取当前时间

PerformanceCounter的nextValue()获取当前cpu的使用效能

多核

cpu:getProcessorInfor() 获得多核处理器的信息

setThreadAffinityMask() 指定cpu在哪个处理器上运行

getCpuTicketCount() 拿到cpu运行的周期数

**代码清单**

```
参数level表示花曲线的百分比

static void makeUsage(float level) {

​		PerformanceCounter p = new PerformanceCounter("","","")

​	   while(true){

​			if(p.NextValue() > level) {

  	  		sleep(10)    

 	    }

​	}

}

画正弦，无非就是busy和idle的时间是变的，使用数组来存放变化的时间

for(int i =0;i<count;i++) {

​		//cpu忙碌的时间

​		busySpan[i] = (half+(sin(pi * radian) * half))

​		//cpu空闲的时间

​		idleSpan[i] = Interval -busySpan[i]

​		radian += split;

}

//一直循环就让它一直画

while(true) {

​		j=j % count;

​		startTime = GetTickCount();

​		while(GetTickCount()-startTime<=busySpan[i]){

​		}

​		sleep(idleSpan[j]);

​		j++;

}
```