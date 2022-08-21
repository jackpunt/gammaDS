package com.thegraid.gamma;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/spring-boot/
@PropertySource("classpath:application.properties") // the 'default' location...
@RestController
public class HelloController {
    @GetMapping("/")
	public String index() {
		return String.format("Greetings from Spring Boot! [%s]\n", this.serverPort);
	}
    @Value("${server.port}")
    String serverPort;

    // https://www.baeldung.com/spring-value-annotation  (with SpEL "#{...}")
    //@Autowired
    public void setValues(@Value("#{'${listOfValues}'.split(',')}") List<String> values) {
        this.values.addAll(values);
    }
    List<String> values;
}
