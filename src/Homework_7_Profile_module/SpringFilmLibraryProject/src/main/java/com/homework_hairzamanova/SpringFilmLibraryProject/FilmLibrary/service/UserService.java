package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.RoleDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.UserDTO;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.mapper.UserMapper;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Order;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.User;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.OrderRepository;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends GenericService<User, UserDTO> {
    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        super(userRepository, userMapper);
    }

    @Override
    public UserDTO create(UserDTO newObject) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        newObject.setRole(roleDTO);
        return mapper.toDTO((repository.save(mapper.toEntity(newObject))));
    }
}
