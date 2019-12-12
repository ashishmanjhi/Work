package springboot.hystrix;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class Resource {
	
	
	@HystrixCommand(fallbackMethod="fallBackHello",
			commandKey="hello",groupKey="hello")
	@GetMapping("/hello")
	public String hello() {
		
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("Fail");
		}
		return "Hello M";
	}

	   @HystrixCommand(fallbackMethod = "fallBackHello",
	            commandKey = "helloYT", groupKey = "helloYT")
	    @GetMapping("/helloYT")
	    public String helloYT() {
	        //Wrong
	        if (RandomUtils.nextBoolean()) {
	            throw new RuntimeException("Failed!");
	        }
	        return "Hello World Youtube";
	    }
	
	public String fallBackHello() {
		return "Fall back hello on";
		
	}
}
