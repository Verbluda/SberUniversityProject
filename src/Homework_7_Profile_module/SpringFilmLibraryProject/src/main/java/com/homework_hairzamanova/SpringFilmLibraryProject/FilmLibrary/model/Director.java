package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "directors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "directors_sequence", allocationSize = 1)
public class Director extends GenericModel {
    @Column(name = "directors_fio", nullable = false)
    private String directorsFio;
    @Column(name = "position", nullable = false)
    private String position;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "films_directors",
            joinColumns = @JoinColumn(name = "director_id"),
            foreignKey = @ForeignKey(name = "FK_DIRECTORS_FILMS"),
            inverseJoinColumns = @JoinColumn(name = "film_id"),
            inverseForeignKey = @ForeignKey(name = "FK_FILMS_DIRECTORS"))
    List<Film> films;
}
