package Thread.channel;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MemoryChannel extends Channel {

	private ArrayBlockingQueue<String> queue = null;

	public MemoryChannel() {
		this.queue = new ArrayBlockingQueue<String>(100);
	}

	@Override
	protected void doPush(String r) {
		try {
			this.queue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPushAll(Collection<String> rs) {
		this.queue.addAll(rs);
	}

	@Override
	protected String doPull() {
		try {
			String record = this.queue.take();
			return record;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void doPullAll(Collection<String> rs) {
		//将所有的存放在共享变量bufferSize中
//		while (this.queue.drainTo(rs, bufferSize) <= 0) {
//			notEmpty.await(200L, TimeUnit.MILLISECONDS);
//		}
	}
}
