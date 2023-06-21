package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Long> {
}
