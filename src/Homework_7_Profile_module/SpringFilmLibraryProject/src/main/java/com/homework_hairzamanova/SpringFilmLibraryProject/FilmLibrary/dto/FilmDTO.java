package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class FilmDTO extends GenericDTO {
    private String title;
    private LocalDate premierYear;
    private String country;
    private Genre genre;
    List<Long> directorsIds;
}
