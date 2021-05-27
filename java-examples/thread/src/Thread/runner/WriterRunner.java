package Thread.runner;

import Thread.receiver.RecordReceiver;

public class WriterRunner extends  AbstractRunner implements Runnable {

	private RecordReceiver recordReceiver;

	public WriterRunner(RecordReceiver recordReceiver) {
		this.recordReceiver = recordReceiver;
	}

	@Override
	public void run() {
		//write插件
		//init()
		//prepare()
		//从recordReceiver的子类 BufferedRecordExchanger 获取数据
		startWrite(recordReceiver);
		//post()
		//destroy()

	}

	//具体插件写入数据操作
	public void startWrite(RecordReceiver recordReceiver) {
		String record = "";
		while((record = recordReceiver.getFromReader()) != null){
			if(record.equals("end")){
				System.out.println(record);
				break;
			}
			System.out.println(record);
		}
	}

}
