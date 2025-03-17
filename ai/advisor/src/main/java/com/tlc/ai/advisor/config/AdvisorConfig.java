package com.tlc.ai.advisor.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdvisorConfig {

    @Bean
    public ChatClient chatClient (ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
