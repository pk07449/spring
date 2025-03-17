package com.tlc.ai.advisor.resource;

import com.tlc.ai.advisor.dto.ActorFilms;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class MovieController {

    @Autowired
    private ChatClient chatClient;

//    public MovieController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }

    @GetMapping("/ai")
    String generation(String userInput) {
        return this.chatClient.prompt()//This method with no arguments lets you start using the fluent API, allowing you to build up user, system, and other parts of the prompt.
                .user(userInput)
                .call()//The call() method sends a request to the AI model.
                .content();//and the content() method returns the AI model’s response as a String.
    }

    @GetMapping("/ai/response/entity/actor-movie")
    ActorFilms actorMovie() {
        ActorFilms actorFilms = chatClient.prompt()
                .user("Generate the filmography for a Akshay Kumar.")
                .call()
                .entity(ActorFilms.class);
        return actorFilms;
        //response
        //{"actor":"Akshay Kumar","movies":["Khiladi","Mohra","Dhadkan","Hera Pheri","Khakee","Singh is Kinng","Housefull","Toilet: Ek Prem Katha","Pad Man","Kesari","Good Newwz","Bachchhan Paandey","Samrat Prithviraj","Raksha Bandhan","Cuttputlli"]}
    }

    @GetMapping("/ai/response/entity/actor-movies")
    List<ActorFilms> actorMovieList(String userInput) {
        List<ActorFilms> actorFilms = chatClient.prompt()
                .user("Generate the filmography of 5 movies for Akshay kumar and Salman Khan.")
                .call()
                .entity(new ParameterizedTypeReference<List<ActorFilms>>() {
                });
        return actorFilms;

        //response
        //[{"actor":"Akshay Kumar","movies":["Hera Pheri","Khiladi","Airlift","Toilet: Ek Prem Katha","Pad Man"]},{"actor":"Salman Khan","movies":["Bajrangi Bhaijaan","Sultan","Kick","Tiger Zinda Hai","Dabangg"]}]
    }


}