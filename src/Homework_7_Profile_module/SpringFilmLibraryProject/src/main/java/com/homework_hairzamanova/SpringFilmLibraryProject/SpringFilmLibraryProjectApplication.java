package com.homework_hairzamanova.SpringFilmLibraryProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;


@SpringBootApplication
public class SpringFilmLibraryProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringFilmLibraryProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws SQLException {
		System.out.println("Swagger path: http://localhost:8080/swagger-ui/index.html");
	}
}
