package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "orders_sequence", allocationSize = 1)
public class Order extends GenericModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_ORDERS_USERS"))
    @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_ORDERS_FILMS"))
    @JsonIgnore
    private Film film;
    @Column(name = "rent_date", nullable = false)
    private LocalDateTime rentDate;
    @Column(name = "rent_period", nullable = false)
    private Integer rentPeriod;
    @Column(name = "purchase", nullable = false)
    private Boolean purchase;
}
