package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.OrderDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.UserDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper.OrderMapper;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Order;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.User;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.OrderRepository;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class OrderService extends GenericService<Order, OrderDTO> {

    private final UserRepository userRepository;
    protected OrderService(OrderRepository orderRepository,
                           UserRepository userRepository,
                           OrderMapper orderMapper) {
        super(orderRepository, orderMapper);
        this.userRepository = userRepository;
    }

    public List<OrderDTO> getUserOrders(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        return mapper.toDTOs(user.getOrders());
    }
}