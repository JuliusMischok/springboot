package de.mischok.exploration.springboot.application;

import java.util.ResourceBundle;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ResourceBundle applicationProperties = ResourceBundle.getBundle("application");
		
		// Migrate database
		Flyway flyway = new Flyway();
		flyway.setDataSource(applicationProperties.getString("spring.datasource.url"), applicationProperties.getString("spring.datasource.username"), applicationProperties.getString("spring.datasource.password"));
		flyway.migrate();
		
		// Start application
		SpringApplication.run(Application.class, args);
	}
}
