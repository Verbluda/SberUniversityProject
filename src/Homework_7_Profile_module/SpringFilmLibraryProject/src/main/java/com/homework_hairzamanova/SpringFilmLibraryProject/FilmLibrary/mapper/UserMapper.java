package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.UserDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.GenericModel;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.User;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper extends GenericMapper<User, UserDTO> {
    private final OrderRepository orderRepository;

    public UserMapper(ModelMapper modelMapper,
                      OrderRepository orderRepository) {
        super(User.class, UserDTO.class, modelMapper);
        this.orderRepository = orderRepository;
    }


    @Override
    protected void setupMapper() {
        modelMapper.createTypeMap(User.class, UserDTO.class)
                .addMappings(mapping -> mapping.skip(UserDTO::setUserFilmsRent))
                .setPostConverter(toDTOConverter());
        modelMapper.createTypeMap(UserDTO.class, User.class)
                .addMappings(mapping -> mapping.skip(User::setOrders))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFields(UserDTO source, User destination) {
        if (!Objects.isNull(source.getUserFilmsRent())) {
            destination.setOrders(orderRepository.findAllById(source.getUserFilmsRent()));
        }
        else {
            destination.setOrders(Collections.emptyList());
        }
    }

    @Override
    protected void mapSpecificFields(User source, UserDTO destination) {
        destination.setUserFilmsRent(getIds(source));
    }

    @Override
    protected List<Long> getIds(User entity) {
        return Objects.isNull(entity) || Objects.isNull(entity.getOrders())
                ? null
                : entity.getOrders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
