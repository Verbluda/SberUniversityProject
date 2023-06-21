package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Director;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Film;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface FilmRepository extends GenericRepository<Film> {
}
