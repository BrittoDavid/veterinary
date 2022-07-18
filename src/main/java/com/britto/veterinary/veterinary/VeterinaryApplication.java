package com.britto.veterinary.veterinary;

import java.util.concurrent.Executors;
import org.quartz.Scheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeterinaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinaryApplication.class, args);
	}
        
//        @Bean
//	public Scheduler jdbcScheduler() {
//		return Schedulers.fromExecutor(Executors.newFixedThreadPool(connectionPoolSize));
//	}

}
