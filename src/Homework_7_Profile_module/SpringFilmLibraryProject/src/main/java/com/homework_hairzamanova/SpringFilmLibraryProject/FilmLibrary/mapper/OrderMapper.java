package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.OrderDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Order;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.FilmRepository;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.UserRepository;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.FilmService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.List;


@Component
public class OrderMapper extends GenericMapper<Order, OrderDTO> {
    private final FilmRepository filmRepository;
    private final UserRepository userRepository;
    private final FilmService filmService;

    public OrderMapper(ModelMapper modelMapper,
                       FilmRepository filmRepository,
                       UserRepository userRepository,
                       FilmService filmService) {
        super(Order.class, OrderDTO.class, modelMapper);
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
        this.filmService = filmService;
    }


    @Override
    protected void setupMapper() {
        super.modelMapper.createTypeMap(Order.class, OrderDTO.class)
                .addMappings(mapping -> mapping.skip(OrderDTO::setUserId))
                .addMappings(mapping -> mapping.skip(OrderDTO::setFilmId))
                .addMappings(mapping -> mapping.skip(OrderDTO::setFilmDTO))
                .setPostConverter(toDTOConverter());
        super.modelMapper.createTypeMap(OrderDTO.class, Order.class)
                .addMappings(mapping -> mapping.skip(Order::setUser))
                .addMappings(mapping -> mapping.skip(Order::setFilm))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(OrderDTO source, Order destination) {
        destination.setFilm(filmRepository.findById(source.getFilmId())
                .orElseThrow(() -> new NotFoundException("Фильм не найден!")));
        destination.setUser(userRepository.findById(source.getUserId())
                .orElseThrow(() -> new NotFoundException("Пользователь не найден!")));
    }

    @Override
    protected void mapSpecificFields(Order source, OrderDTO destination) {
        destination.setFilmId(source.getFilm().getId());
        destination.setUserId(source.getUser().getId());
        destination.setFilmDTO(filmService.getOne(source.getFilm().getId()));
    }

    @Override
    protected List<Long> getIds(Order entity) {
        throw new UnsupportedOperationException("Метод недоступен");
    }
}
