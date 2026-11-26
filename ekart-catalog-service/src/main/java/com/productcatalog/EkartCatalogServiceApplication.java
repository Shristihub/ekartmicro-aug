package com.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EkartCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartCatalogServiceApplication.class, args);
	}

}
