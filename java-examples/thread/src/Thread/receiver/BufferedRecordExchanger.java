package Thread.receiver;

import Thread.channel.Channel;

import java.util.ArrayList;
import java.util.List;

public class BufferedRecordExchanger implements RecordSender,RecordReceiver {
	private final List<String> buffer =new ArrayList<String>();

	private final Channel channel;

	public BufferedRecordExchanger(Channel channel) {
		this.channel = channel;
	}

	@Override
	public  String getFromReader() {
		//如果有数据返回数据，没有数据从channel获取数据
		//receive()      //队列中获取数据
		String record = this.channel.pull();
		return record;
	}


	@Override
	public void sendToWriter(String record) {
		//获取元素放到集合中
		this.channel.push(record);
	}
}
