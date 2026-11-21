package com.productcatalogview.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@Configuration
public class WebConfig {
	
	//create a bean for RestClient.Builder object 
	@Bean
	@Primary
	RestClient.Builder builder(){
		return RestClient.builder();
	}
	
	//create a bean for RestClient.Builder object 
		@Bean
		@LoadBalanced
		RestClient.Builder loadBalancedBuilder(){
			return RestClient.builder();
		}

}
