package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends GenericRepository<Order> {
    Page<Order> getOrderByUserId(Long id, Pageable pageRequest);
}
