package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "uniquePhone", columnNames = "phone"),
                @UniqueConstraint(name = "uniqueLogin", columnNames = "login"),
                @UniqueConstraint(name = "uniqueEmail", columnNames = "email")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "users_sequence", allocationSize = 1)
public class User extends GenericModel {
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "created_when")
    private LocalDateTime createdWhen;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false,
    foreignKey = @ForeignKey(name = "FK_USERS_ROLES"))
    private Role role;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
