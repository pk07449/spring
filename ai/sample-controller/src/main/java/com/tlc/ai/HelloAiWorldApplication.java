package com.tlc.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.tlc.ai.chatClient.resource")
public class HelloAiWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloAiWorldApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ChatClient.Builder builder) {
		return args -> {
			ChatClient chatClient = builder.build();
			String response = chatClient.prompt("Who is the PM of india").call().content();
			System.out.println(response);
		};
	}

}
