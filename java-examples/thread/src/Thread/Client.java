package Thread;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		ProcessInnerScheduler scheduler = new ProcessInnerScheduler();

		List<String> configurations = new ArrayList<String>();
		configurations.add("configuration");
		configurations.add("configuration");
		configurations.add("configuration");
		configurations.add("configuration");
		configurations.add("configuration");

		scheduler.startAllTaskGroup(configurations);
	}
}
