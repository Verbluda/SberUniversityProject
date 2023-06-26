package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.DirectorDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper.DirectorMapper;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Director;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Film;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.DirectorRepository;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.FilmRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class DirectorService extends GenericService<Director, DirectorDTO> {
    private final FilmRepository filmRepository;

    public DirectorService(DirectorRepository directorRepository,
                           DirectorMapper directorMapper,
                           FilmRepository filmRepository) {
        super(directorRepository, directorMapper);
        this.filmRepository = filmRepository;
    }

    public DirectorDTO addFilm(Long filmId, Long directorId) {
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new NotFoundException("Фильм не найден!"));
        DirectorDTO director = getOne(directorId);
        director.getFilmsIds().add(film.getId());
        update(director);
        return director;
    }
}
