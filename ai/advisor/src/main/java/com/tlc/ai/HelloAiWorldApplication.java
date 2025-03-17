package com.tlc.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.tlc.ai.advisor")
public class HelloAiWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloAiWorldApplication.class, args);
	}
}
