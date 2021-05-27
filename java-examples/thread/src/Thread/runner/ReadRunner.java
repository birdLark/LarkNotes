package Thread.runner;

import Thread.receiver.RecordSender;

public class ReadRunner extends  AbstractRunner implements Runnable {


	private RecordSender recordSender;

	public ReadRunner(RecordSender recordSender) {
		this.recordSender = recordSender;
	}

	@Override
	public void run() {
		//read插件
		//init()
		//prepare()
		startRead(recordSender);
		//post()
		//destroy()
	}

	//具体插件读取数据操作
	public void startRead(RecordSender recordSender) {
		String testdata = "i am test tranform";
		for(int i = 0;i<2;i++) {
			recordSender.sendToWriter(testdata);
		}
		recordSender.sendToWriter("end");
	}
}
