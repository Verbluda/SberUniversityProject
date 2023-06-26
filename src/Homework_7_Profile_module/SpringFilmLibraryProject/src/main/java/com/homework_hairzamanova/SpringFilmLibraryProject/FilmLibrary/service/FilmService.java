package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.FilmDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper.FilmMapper;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Director;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Film;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.DirectorRepository;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.FilmRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class FilmService extends GenericService<Film, FilmDTO> {
    private final DirectorRepository directorRepository;

    public FilmService(FilmRepository filmRepository,
                       FilmMapper filmMapper,
                       DirectorRepository directorRepository) {
        super(filmRepository, filmMapper);
        this.directorRepository = directorRepository;
    }

    public FilmDTO addDirector(final Long filmId,
                               final Long directorId) {
        FilmDTO film = getOne(filmId);
        Director director = directorRepository.findById(directorId).orElseThrow(() -> new NotFoundException("Режиссер не найден!"));
        film.getDirectorsIds().add(director.getId());
        update(film);
        return film;
    }
}
