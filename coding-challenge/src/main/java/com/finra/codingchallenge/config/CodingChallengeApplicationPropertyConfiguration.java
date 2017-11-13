package com.finra.codingchallenge.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Configuration
@PropertySource(name = "applicationProperties", value = "classpath:application.properties", ignoreResourceNotFound = false)
public class CodingChallengeApplicationPropertyConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(CodingChallengeApplicationPropertyConfiguration.class);

	@Bean
	public static PropertySourcesPlaceholderConfigurer pspc() {
		LOGGER.info("Loading the properties");
		PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
		pspc.setLocalOverride(true);
		return pspc;
	}
}
