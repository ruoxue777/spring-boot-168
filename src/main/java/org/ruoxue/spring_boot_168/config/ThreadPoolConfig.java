package org.ruoxue.spring_boot_168.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ThreadPoolConfig {
	public static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();
	public static final int MAX_POOLSIZE = 50 * CORE_POOL_SIZE;
	public static final long KEEP_LIVE_TIME = 60000L;
	public static final int QUEUE_CAPACITY = 10;

	@Bean(value = "sysThreadPool")
	public ExecutorService sysThreadPool() {
		String prefix = "SYS-T-";
		ExecutorService executor = new ThreadPoolExecutor(CORE_POOL_SIZE, //
				MAX_POOLSIZE, //
				KEEP_LIVE_TIME, //
				TimeUnit.MILLISECONDS, //
				new SynchronousQueue<>(), //
				new NamedThreadFactory(prefix), //
				new CallerRunsPolicy() //
		);
		log.info("prefix: " + prefix);
		return executor;
	}

	@Bean(value = "gameThreadPool")
	public ExecutorService gameThreadPool() {
		String prefix = "GAME-T-";
		ExecutorService executor = new ThreadPoolExecutor(CORE_POOL_SIZE, //
				MAX_POOLSIZE, //
				KEEP_LIVE_TIME, //
				TimeUnit.MILLISECONDS, //
				new SynchronousQueue<>(), //
				new NamedThreadFactory(prefix), //
				new CallerRunsPolicy() //
		);
		log.info("prefix: " + prefix);
		return executor;
	}

	@Bean(value = "mqThreadPool")
	public ExecutorService mqThreadPool() {
		String prefix = "MQ-T-";
		ExecutorService executor = new ThreadPoolExecutor(CORE_POOL_SIZE, //
				MAX_POOLSIZE, //
				KEEP_LIVE_TIME, //
				TimeUnit.MILLISECONDS, //
				new SynchronousQueue<>(), //
				new NamedThreadFactory(prefix), //
				new CallerRunsPolicy() //
		);
		log.info("prefix: " + prefix);
		return executor;
	}

	public class NamedThreadFactory implements ThreadFactory {
		private final AtomicInteger count = new AtomicInteger();
		private final String prefix;

		public NamedThreadFactory(String prefix) {
			this.prefix = prefix;
		}

		@Override
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			int c = count.incrementAndGet();
			thread.setName(prefix + "-" + c);
			return thread;
		}
	}
}
