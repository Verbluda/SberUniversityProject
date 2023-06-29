package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User> {
    User findUserByLogin(String login);
    User findUserByEmail(String email);
}
