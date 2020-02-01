package org.aztec.sovn.core.mas.utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
	
	public static Future<?> execute(Runnable task) {
		return service.submit(task);
	}

}
