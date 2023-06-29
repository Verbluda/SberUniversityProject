package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model;

public enum Genre {
    COMEDY("Комедия"),
    HORROR("Ужасы"),
    FANTASY("Фэнтези"),
    SCIENCE_FICTION("Научная фантастика"),
    ADVENTURE("Приключенческое"),
    THRILLER("Триллер"),
    ACTION("Боевик"),
    MELODRAMA("Мелодрама"),
    DETECTIVE("Детектив"),
    DRAMA("Драма"),
    DOCUMENTARY("Документальное"),
    BIOPIC("Биография"),
    WESTERN("Вестерн");

    private final String genreTextDisplay;
    Genre(String text) {this.genreTextDisplay = text;}

    public String getGenreTextDisplay() {
        return this.genreTextDisplay;
    }
}
