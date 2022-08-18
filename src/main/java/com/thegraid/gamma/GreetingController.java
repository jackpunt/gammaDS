package com.thegraid.gamma;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/rest-service/
// versus: https://spring.io/guides/gs/serving-web-content/ (which returns set a Model & return a View-name)

// because it returns a Java Object, Spring runs it through Jackson.toJSON()
@RestController // @Controller and @ResponseBody
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/json-greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}