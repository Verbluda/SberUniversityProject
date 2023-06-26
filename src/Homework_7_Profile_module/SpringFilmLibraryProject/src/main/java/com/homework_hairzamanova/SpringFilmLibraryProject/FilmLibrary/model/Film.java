package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "films")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "films_sequence", allocationSize = 1)
public class Film extends GenericModel {
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "premier_year")
    private LocalDateTime premierYear;
    @Column(name = "country")
    private String country;
    @Column(name = "genre", nullable = false)
    @Enumerated
    private Genre genre;
    @ManyToMany
    @JoinTable(name = "films_directors",
            joinColumns = @JoinColumn(name = "film_id"),
            foreignKey = @ForeignKey(name = "FK_FILMS_DIRECTORS"),
            inverseJoinColumns = @JoinColumn(name = "director_id"),
            inverseForeignKey = @ForeignKey(name = "FK_DIRECTORS_FILMS"))
    List<Director> directors;

    @OneToMany(mappedBy = "film")
    private List<Order> orders;
}
