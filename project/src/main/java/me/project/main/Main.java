package me.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "me.project")
@EnableJpaRepositories(basePackages = "me.project")
@EntityScan(basePackages = "me.project")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	

}
