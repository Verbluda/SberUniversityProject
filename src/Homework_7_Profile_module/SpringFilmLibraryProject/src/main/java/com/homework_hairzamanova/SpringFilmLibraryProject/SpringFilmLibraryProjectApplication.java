package com.homework_hairzamanova.SpringFilmLibraryProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLException;


@SpringBootApplication
public class SpringFilmLibraryProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringFilmLibraryProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws SQLException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode("admin");
		System.out.println(hashedPassword);

		System.out.println("Swagger path: http://localhost:8080/swagger-ui/index.html");
		System.out.println("Application path: http://localhost:8080");
	}
}
