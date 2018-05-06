package rest.contentNegotation;

/**
 * Created by pankaj on 10/28/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@ComponentScan(basePackages = "rest.contentNegotation")
@SpringBootApplication
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter {

    /**
     * Setup a simple strategy: use all the defaults and return XML by default when not sure.
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_XML);
        configurer.favorParameter(true);
        configurer.parameterName("formatType");
        configurer.ignoreAcceptHeader(false);
        Map<String, MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("json", MediaType.APPLICATION_XML);
        mediaTypes.put("xml", MediaType.APPLICATION_JSON);
        configurer.mediaTypes(mediaTypes);

    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}