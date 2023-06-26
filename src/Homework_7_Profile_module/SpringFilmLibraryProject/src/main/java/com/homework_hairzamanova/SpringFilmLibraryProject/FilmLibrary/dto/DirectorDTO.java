package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class DirectorDTO extends GenericDTO{
    private String directorsFio;
    private String position;
    List<Long> filmsIds;
}
