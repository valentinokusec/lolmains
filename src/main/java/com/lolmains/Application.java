package com.lolmains;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lolmains.services.FillData;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	  ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        
        context.getBean(FillData.class).fillWithTestdata();
    }

   

}
