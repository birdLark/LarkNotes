package Thread;

public class TaskGroupRunner implements Runnable {

	private TaskGroupContainer taskGroupContainer = new TaskGroupContainer();

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		taskGroupContainer.start();
	}

}
