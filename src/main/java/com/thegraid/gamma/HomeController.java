package com.thegraid.gamma;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/spring-boot/
@PropertySource("classpath:application.properties") // the 'default' location...
@RestController
public class HomeController {
    @GetMapping("/")
	public String index() {
		return String.format("gammaDS.HomeController Port [%s]\n", this.serverPort);
	}
    @Value("${server.port}")
    String serverPort;

}
