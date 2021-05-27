package Thread;

import Thread.channel.Channel;
import Thread.channel.MemoryChannel;
import Thread.receiver.BufferedRecordExchanger;
import Thread.runner.ReadRunner;
import Thread.runner.WriterRunner;

public class TaskGroupContainer {

	private  Thread writerThread;
	private  Thread readerThread;
	private  Channel channel;

	public TaskGroupContainer() {
		channel = new MemoryChannel();
		WriterRunner writerRunner =  new WriterRunner(new BufferedRecordExchanger(channel));
		this.writerThread = new Thread(writerRunner,"writer");

		ReadRunner readRunner = new ReadRunner(new BufferedRecordExchanger(channel));
		this.readerThread = new Thread(readRunner,"reader");
	}

	public void start() {
		this.writerThread.start();
		this.readerThread.start();
	}
}
