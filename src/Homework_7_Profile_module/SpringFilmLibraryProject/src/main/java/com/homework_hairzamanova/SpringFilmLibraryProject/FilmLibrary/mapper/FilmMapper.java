package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.FilmDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Film;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.GenericModel;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.DirectorRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class FilmMapper extends GenericMapper<Film, FilmDTO> {
    private final DirectorRepository directorRepository;

    protected FilmMapper(ModelMapper modelMapper, DirectorRepository directorRepository) {
        super(Film.class, FilmDTO.class, modelMapper);
        this.directorRepository = directorRepository;
    }

    @PostConstruct
    protected void setupMapper() {
        modelMapper.createTypeMap(Film.class, FilmDTO.class)
                .addMappings(mapping -> mapping.skip(FilmDTO::setDirectorsIds))
                .setPostConverter(toDTOConverter());

        modelMapper.createTypeMap(FilmDTO.class, Film.class)
                .addMappings(mapping -> mapping.skip(Film::setDirectors))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(FilmDTO source, Film destination) {
        if (!Objects.isNull(source.getDirectorsIds())) {
            destination.setDirectors(directorRepository.findAllById(source.getDirectorsIds()));
        } else {
            destination.setDirectors(Collections.emptyList());
        }
    }

    @Override
    protected void mapSpecificFields(Film source, FilmDTO destination) {
        destination.setDirectorsIds((getIds(source)));
    }

    @Override
    protected List<Long> getIds(Film film) {
        return Objects.isNull(film) || Objects.isNull(film.getDirectors())
                ? null
                : film.getDirectors().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
