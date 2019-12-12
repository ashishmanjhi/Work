package springboot.stock.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaServer
@SpringBootApplication
public class SpringStockEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStockEurekaServiceApplication.class, args);
	}

}
