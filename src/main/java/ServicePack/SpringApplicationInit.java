package ServicePack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by alex on 07.04.17.
 */
//@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class SpringApplicationInit {
    public static void main(String[] args) {

        SpringApplication.run(SpringApplicationInit.class, args);


    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET")
                        .allowedHeaders("Access-Control-Allow-Origin", "*")

                        .maxAge(3600);
            }
        };
    }
}
