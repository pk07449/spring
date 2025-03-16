package com.tlc.ai.chatClient.resource;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Flux;
@RestController

public class StreamResponseController {

    private final ChatClient chatClient;

    public StreamResponseController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ai/response/stream")
    Flux<String> streamResponse(String userInput) {
        Flux<String> output = chatClient.prompt()
                .user("Tell me a joke")
                .stream()
                .content();
        return  output;
    }



}
