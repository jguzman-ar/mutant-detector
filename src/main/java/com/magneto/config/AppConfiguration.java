package com.magneto.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfiguration {
	
	@Autowired
	private PersistenceExecutorConfig executorConfig;
	 
	@Bean(name = "taskExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(executorConfig.getCorePoolSize());
        executor.setMaxPoolSize(executorConfig.getMaxPoolSize());
        executor.setQueueCapacity(executorConfig.getQueueCapacity());
        executor.setThreadNamePrefix(executorConfig.getPersistenceThreadName());
        executor.initialize();
        return executor;
    }

}
