package ua.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {

//        SpringApplication.run(CustomerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(CustomerApplication.class);
        System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
        springApplication.run(args);

    }

}
