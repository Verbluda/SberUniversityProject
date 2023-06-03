package com.homework_hairzamanova.SpringLibraryProject.dbexample.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String surname;
    private String name;
    private Date birthday;
    private String phone;
    private String email;
    private String[] books;
}
