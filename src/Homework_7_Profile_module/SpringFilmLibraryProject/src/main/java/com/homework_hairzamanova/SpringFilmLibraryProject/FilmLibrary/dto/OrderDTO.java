package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO extends GenericDTO {
    private Long userId;
    private Long filmId;
    private LocalDateTime rentDate;
    private Integer rentPeriod;
    private Boolean purchase;
    private FilmDTO filmDTO;
}
