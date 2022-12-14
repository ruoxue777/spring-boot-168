package org.ruoxue.spring_boot_168.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

//@EnableAsync
//@Configuration
@Slf4j
public class AsyncConfig implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {
		String prefix = "ASYNC-T-";
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadNamePrefix(prefix);
		executor.setCorePoolSize(ThreadPoolConfig.CORE_POOL_SIZE);
		executor.setMaxPoolSize(ThreadPoolConfig.MAX_POOLSIZE);
		executor.setQueueCapacity(ThreadPoolConfig.QUEUE_CAPACITY);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		log.info("prefix: " + prefix);
		log.info("corePoolSize: " + executor.getCorePoolSize());
		log.info("maxPoolSize: " + executor.getMaxPoolSize());
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}

}
