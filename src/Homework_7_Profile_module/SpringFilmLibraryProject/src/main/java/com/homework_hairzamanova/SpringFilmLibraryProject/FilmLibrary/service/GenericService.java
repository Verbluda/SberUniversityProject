package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.GenericDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper.GenericMapper;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.GenericModel;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.GenericRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public abstract class GenericService<E extends GenericModel, D extends GenericDTO> {
    protected final GenericRepository<E> repository;
    protected final GenericMapper<E, D> mapper;

    public GenericService(GenericRepository<E> repository, GenericMapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
     public List<D> listAll() {
        return mapper.toDTOs((repository.findAll()));
     }

     public D getOne(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new NotFoundException("Данных по заданному id: " + id + " не найдено")));
     }

     public D create(D newObject) {
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
     }

     public D update(D updatedObject) {
      return mapper.toDTO(repository.save(mapper.toEntity(updatedObject)));
     }

     public void delete(final Long id) {
        repository.deleteById(id);
     }
}
