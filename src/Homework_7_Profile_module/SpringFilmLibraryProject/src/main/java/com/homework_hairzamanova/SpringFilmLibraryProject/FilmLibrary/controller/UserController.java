package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.UserDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.User;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Контроллер для работы с пользователями из фильмотеки")
public class UserController extends GenericController<User, UserDTO> {
    public UserController(UserService userService) {
        super(userService);
    }

}