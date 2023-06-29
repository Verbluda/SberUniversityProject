package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller.mvc;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.FilmDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/films")
public class MVCFilmController {

    private final FilmService filmService;

    public MVCFilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<FilmDTO> films = filmService.listAll();
        model.addAttribute("films", films);
        return "films/viewAllFilms";
    }

    @GetMapping("/add")
    public String create() {
        return "films/addFilm";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute("filmForm") FilmDTO newFilm) {
        log.info(newFilm.toString());
        filmService.create(newFilm);
        return "redirect:/films";
    }

}

