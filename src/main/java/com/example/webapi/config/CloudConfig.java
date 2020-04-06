package com.example.webapi.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;

@Configuration
@ServiceScan
public class CloudConfig extends AbstractCloudConfig {

	@Bean
	public MongoDbFactory documentMongoDbFactory() {
		return connectionFactory().mongoDbFactory("document-service");
	}
}
