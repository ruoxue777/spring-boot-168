package org.ruoxue.spring_boot_168.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc 
@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") //
				.allowedOrigins("*") //
				.allowCredentials(true) //
				.allowedMethods("*") //
				.allowedHeaders("*") //
				.exposedHeaders("Authorization", "Accept", "X-Requested-With", "Origin",
						"Access-Control-Request-Method", "Access-Control-Request-Headers",
						"Access-Control-Expose-Headers", "Content-Length", "Content-Range") //
				.maxAge(1800) // 30min
		; //
	}

	@Bean
	public ThreadPoolTaskExecutor asyncExecutor() {
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

	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setTaskExecutor(asyncExecutor());
	}
}
