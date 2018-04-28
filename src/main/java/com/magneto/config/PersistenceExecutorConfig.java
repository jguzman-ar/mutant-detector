package com.magneto.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("persistence.executor")
public class PersistenceExecutorConfig {
	
	private int corePoolSize;
	private int maxPoolSize;
	private int queueCapacity;
	private String persistenceThreadName;

	public int getCorePoolSize() {
		return corePoolSize;
	}
	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}
	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
	public int getQueueCapacity() {
		return queueCapacity;
	}
	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}
	public String getPersistenceThreadName() {
		return persistenceThreadName;
	}
	public void setPersistenceThreadName(String persistenceThreadName) {
		this.persistenceThreadName = persistenceThreadName;
	}
 
}
