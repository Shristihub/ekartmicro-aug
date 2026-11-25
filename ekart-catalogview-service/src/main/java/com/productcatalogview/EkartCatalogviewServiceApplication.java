package com.productcatalogview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EkartCatalogviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartCatalogviewServiceApplication.class, args);
	}

}
