package Thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class CASCount {
	private static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//每个线程让count自增100次
					for (int i = 0; i < 100; i++) {
						count.incrementAndGet();
					}
				}
			}).start();
		}

		try{
			Thread.sleep(2000);
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(count);
	}
}
