package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Director;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.DirectorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/directors") // http://localhost:8081/directors
public class DirectorController {

    private final DirectorRepository directorRepository;

    public DirectorController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }
    @RequestMapping(value = "/getOneById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Director> getOneById(@RequestParam(value = "id") Long id) { // http://localhost:8081/directors/getOneById?id=3
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(directorRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Данные по переданному ID не найдены!")));
    }
}
