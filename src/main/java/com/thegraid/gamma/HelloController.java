package com.thegraid.gamma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/spring-boot/
@RestController
public class HelloController {
    @GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot! ["+this.value+"]\n";
	}
    @Value("${server.port}")
    String value;
}
