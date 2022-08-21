package com.thegraid.gamma;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// https://spring.io/guides/gs/rest-service/
// versus: https://spring.io/guides/gs/serving-web-content/ (which returns set a Model & return a View-name)

// https://www.baeldung.com/spring-boot-internationalization

// because it returns a Java Object, Spring runs it through Jackson.toJSON()
@RestController // @Controller and @ResponseBody
public class GreetingController {

	//private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
    private MessageSource messageSource;

	public GreetingController(MessageSource messageSource) {
		this.messageSource = messageSource;
    }
    public String msg(String key, Object ...args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("welcome_h3", args, locale);
    }
	@GetMapping("/json-greeting")
	public GreetingDTO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        //String greet = messageSource.getMessage("welcome_h3", args, locale);
        String greet = this.msg("welcome_h3", name);
		return new GreetingDTO(counter.incrementAndGet(), greet);
	}
}