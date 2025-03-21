package com.tlc.ai.advisor.resource;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
class RAGController {
    private  ChatClient chatClient;
    private  VectorStore vectorStore;


    public RAGController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    // Assume that we have already read the documents from files containing information about people 
    // and stored them in the VectorStore as described in the previous section.
    
    @GetMapping("/ai/rag/people")
    Person chatWithRag(@RequestParam String name) {
        // Querying the VectorStore using natural language looking for the information about a person.
        List<Document> similarDocuments =
                vectorStore.similaritySearch(SearchRequest.builder().query(name).topK(2).build());
        String information = similarDocuments.stream()
                .map(Document::getFormattedContent)
                .collect(Collectors.joining(System.lineSeparator()));
        
        // Constructing the systemMessage to indicate the AI model to use the passed information
        // to answer the question.
        var systemPromptTemplate = new SystemPromptTemplate("""
              You are a helpful assistant.
              
              Use the following information to answer the question:
              {information}
              """);
        var systemMessage = systemPromptTemplate.createMessage(
                Map.of("information", information));

        // Using BeanOutputConverter to parse the response into an instance of Person.
        var outputConverter = new BeanOutputConverter<>(Person.class);
        
        // Constructing the userMessage to ask the AI model to tell about the person.
        PromptTemplate userMessagePromptTemplate = new PromptTemplate("""
        Tell me about {name} as if current date is {current_date}.

        {format}
        """);
        Map<String,Object> model = Map.of("name", name,
                "current_date", LocalDate.now(),
                "format", outputConverter.getFormat());
        var userMessage = new UserMessage(userMessagePromptTemplate.create(model).getContents());

        var prompt = new Prompt(List.of(systemMessage, userMessage));

        var response = chatClient.prompt(prompt).call().content();

        return outputConverter.convert(response);
    }
}

record Person(String name,
              String dateOfBirth,
              int experienceInYears,
              List<String> books) {
}