package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.constants;

import java.util.List;

public interface SecurityConstants {
    List<String> RESOURCES_WHITE_LIST = List.of("/resources/**",
            "/static/**",
            "/js/**",
            "/css/**",
            "/",
            "/swagger-ui/**",
            "/v3/api-docs/**");
    List<String> USERS_ROLE_REST_WHITE_LIST = List.of(
            "/users/auth",
            "/films/getAll",
            "/directors/getAll",
            "/orders/add",
            "/users/update");

    List<String> ADMIN_ROLE_REST_PERMISSION_LIST = List.of(
            "/users/getAll",
            "/film/add",
            "/directors/add",
            "/film/update",
            "/directors/update",
            "/film/addDirector",
            "/directors/addFilm",
            "/film/getOneById",
            "/directors/getOneById",
            "/film/delete/**",
            "/directors/delete/**",
            "/orders/update",
            "/orders/userOrders",
            "/orders/getOneById",
            "/orders/getAll",
            "/orders/delete/**",
            "/users/add",
            "/users/getOneById",
            "/users/getAll",
            "/users/delete/**");
}
