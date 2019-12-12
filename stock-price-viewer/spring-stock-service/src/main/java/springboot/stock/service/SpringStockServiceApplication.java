package springboot.stock.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStockServiceApplication.class, args);
	}

}
