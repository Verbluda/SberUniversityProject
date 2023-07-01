package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service;
;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.OrderDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper.OrderMapper;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Order;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.User;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.OrderRepository;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService extends GenericService<Order, OrderDTO> {
    private final FilmService filmService;
    private final UserRepository userRepository;
    protected OrderService(OrderRepository orderRepository,
                           OrderMapper orderMapper,
                           FilmService filmService,
                           UserRepository userRepository) {
        super(orderRepository, orderMapper);
        this.filmService = filmService;
        this.userRepository = userRepository;
    }

    public List<OrderDTO> getUserOrders(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        return mapper.toDTOs(user.getOrders());
    }

    public OrderDTO rentFilm(final OrderDTO orderDTO) {
        long rentPeriod = orderDTO.getRentPeriod() != null ? orderDTO.getRentPeriod() : 14L;
        orderDTO.setRentDate(LocalDateTime.now());
        orderDTO.setPurchase(true);
        orderDTO.setRentPeriod((int) rentPeriod);
        return mapper.toDTO(repository.save(mapper.toEntity(orderDTO)));
    }


    public Page<OrderDTO> listUserRentFilms(final Long id,
                                            final Pageable pageRequest) {
        Page<Order> objects = ((OrderRepository) repository).getOrderByUserId(id, pageRequest);
        List<OrderDTO> results = mapper.toDTOs(objects.getContent());
        return new PageImpl<>(results, pageRequest, objects.getTotalElements());
    }

}