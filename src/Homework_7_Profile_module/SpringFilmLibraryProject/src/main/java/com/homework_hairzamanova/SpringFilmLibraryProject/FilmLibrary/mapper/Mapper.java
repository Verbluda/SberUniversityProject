package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.GenericDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDTO> {
    E toEntity(D dto);
    D toDTO(E entity);
    List<E> toEntities(List<D> dtos);
    List<D> toDTOs(List<E> entities);
}
