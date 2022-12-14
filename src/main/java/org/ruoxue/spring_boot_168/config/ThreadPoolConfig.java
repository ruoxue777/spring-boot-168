package org.ruoxue.spring_boot_168.config;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.util.NamedThreadFactory;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ThreadPoolConfig {
	public static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors(); 
	public static final int MAX_POOLSIZE = 50 * CORE_POOL_SIZE;
	public static final long KEEP_LIVE_TIME = 60000L;
	public static final int QUEUE_CAPACITY = 10;

	@Bean(value = "sysThreadPool")
	public ThreadPoolExecutor sysThreadPool() {
		String prefix = "SYS-T-";
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, //
				MAX_POOLSIZE, //
				KEEP_LIVE_TIME, //
				TimeUnit.MILLISECONDS, //
				new SynchronousQueue<>(), //
				new NamedThreadFactory(prefix), //
				new ThreadPoolExecutor.CallerRunsPolicy() //
		);
		log.info("prefix: " + prefix);
		log.info("corePoolSize: " + threadPoolExecutor.getCorePoolSize());
		log.info("maximumPoolSize: " + threadPoolExecutor.getMaximumPoolSize());
		return threadPoolExecutor;
	}

	@Bean(value = "gameThreadPool")
	public ThreadPoolExecutor gameThreadPool() {
		String prefix = "GAME-T-";
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, //
				MAX_POOLSIZE, //
				KEEP_LIVE_TIME, //
				TimeUnit.MILLISECONDS, //
				new SynchronousQueue<>(), //
				new NamedThreadFactory(prefix), //
				new ThreadPoolExecutor.CallerRunsPolicy() //
		);
		log.info("prefix: " + prefix);
		log.info("corePoolSize: " + threadPoolExecutor.getCorePoolSize());
		log.info("maximumPoolSize: " + threadPoolExecutor.getMaximumPoolSize());
		return threadPoolExecutor;
	}

	@Bean(value = "mqThreadPool")
	public ThreadPoolExecutor mqThreadPool() {
		String prefix = "MQ-T-";
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, //
				MAX_POOLSIZE, //
				KEEP_LIVE_TIME, //
				TimeUnit.MILLISECONDS, //
				new SynchronousQueue<>(), //
				new NamedThreadFactory(prefix), //
				new ThreadPoolExecutor.CallerRunsPolicy() //
		);
		log.info("prefix: " + prefix);
		log.info("corePoolSize: " + threadPoolExecutor.getCorePoolSize());
		log.info("maximumPoolSize: " + threadPoolExecutor.getMaximumPoolSize());
		return threadPoolExecutor;
	}
}
