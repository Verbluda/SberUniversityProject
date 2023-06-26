package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO extends GenericDTO {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDateTime birthDate;
    private String phone;
    private String address;
    private String email;
    private LocalDateTime createdWhen;
    private RoleDTO role;
    private List<Long> userFilmsRent;
}
