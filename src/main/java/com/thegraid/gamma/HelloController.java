package com.thegraid.gamma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/spring-boot/
@RestController
public class HelloController {
    @GetMapping("/")
	public String index() {
		return String.format("Greetings from Spring Boot! [%s]\n", this.serverPort);
	}
    @Value("${server.port}")
    String serverPort;
}
