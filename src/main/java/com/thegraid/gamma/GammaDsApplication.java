package com.thegraid.gamma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.thegraid.gamma.util.Ansi;

@SpringBootApplication
public class GammaDsApplication {
	private static final Logger log = LoggerFactory.getLogger(GammaDsApplication.class);
    @Value("${server.port}")
    String serverPort;
	
	public static void main(String[] args) {
		log.info("Running Spring Boot:");
		SpringApplication.run(GammaDsApplication.class, args);
	}
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
		String url = new Ansi(Ansi.RED).format("http://localhost:%s", this.serverPort);
        log.info(String.format("Running. Browse to %s", url));
    }
}
