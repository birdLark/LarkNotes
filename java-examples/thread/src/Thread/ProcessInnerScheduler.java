package Thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessInnerScheduler {
	public void startAllTaskGroup(List<String> configurations) {
		ExecutorService executorService = Executors.newFixedThreadPool(configurations.size());
		for (String configuration : configurations) {
			executorService.execute(new TaskGroupRunner());
		}
		executorService.shutdown();
	}
}
