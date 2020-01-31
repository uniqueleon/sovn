package org.aztec.sovn.core.utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServices {
	
	public static int MAXIUM_THREADS = 100;
	public static ExecutorService service = Executors.newFixedThreadPool(MAXIUM_THREADS);

	public static void setMaxiumThreads(int limit) {
		MAXIUM_THREADS = limit;
		List<Runnable> waitingTask = service.shutdownNow();
		service = Executors.newFixedThreadPool(MAXIUM_THREADS);
		waitingTask.stream().forEach(task -> {
			service.submit(task);
		});
	}
	
	public static void execute(Runnable task) {
		service.submit(task);
	}

}
