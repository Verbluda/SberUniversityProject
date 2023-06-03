package com.homework_hairzamanova.SpringLibraryProject;

import com.homework_hairzamanova.SpringLibraryProject.dbexample.dao.BookDAO;
import com.homework_hairzamanova.SpringLibraryProject.dbexample.dao.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringLibraryProjectApplication implements CommandLineRunner {

	private BookDAO bookDAO;
	private UserDAO userDAO;

	public SpringLibraryProjectApplication(BookDAO bookDAO, UserDAO userDAO) {
		this.bookDAO = bookDAO;
		this.userDAO = userDAO;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringLibraryProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userDAO.addNewUser("Игорев", "Игорь",new Date(1992, 04, 04), "79584763524", "ii@yandex.ru", new String[]{"Недоросль", "Доктор Живаго"});
		System.out.println(bookDAO.findBooksByTitle(userDAO.findBooksByUserPhone("79584763524")));
	}
}
