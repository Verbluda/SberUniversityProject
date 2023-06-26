package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.FilmDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Film;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
@Tag(name = "Фильмы", description = "Контроллер для работы с фильмами из фильмотеки")
public class FilmController extends GenericController<Film, FilmDTO> {

    public FilmController(FilmService service) {
        super(service);
    }

    @Operation(description = "Добавить режиссера к фильму")
    @RequestMapping(value = "/addDirector",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDTO> addDirector(@RequestParam(value = "filmId") Long filmId,
                                            @RequestParam(value = "directorId") Long directorId) {
        return ResponseEntity.status(HttpStatus.OK).body(((FilmService) service).addDirector(filmId, directorId));
    }
}
