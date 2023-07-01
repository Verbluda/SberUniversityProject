package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller.mvc;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.OrderDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.FilmService;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.OrderService;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.userdetails.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/order")
public class MVCOrderController {
    private final OrderService orderService;
    private final FilmService filmService;

    public MVCOrderController(OrderService orderService,
                                     FilmService filmService) {
        this.orderService = orderService;
        this.filmService = filmService;
    }

    @GetMapping("/film/{filmId}")
    public String rentBook(@PathVariable Long filmId,
                           Model model) {
        model.addAttribute("film", filmService.getOne(filmId));
        return "rentFilm";
    }

    @PostMapping("/film")
    public String rentBook(@ModelAttribute("rentBookInfo") OrderDTO rentBookInfoDTO) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        rentBookInfoDTO.setUserId(Long.valueOf(customUserDetails.getId()));
        orderService.rentFilm(rentBookInfoDTO);
        return "redirect:/order/user-films/" + customUserDetails.getId();
    }

    @GetMapping("/user-films/{id}")
    public String userFilms(@RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "size", defaultValue = "5") int pageSize,
                            @PathVariable Long id,
                            Model model) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        Page<OrderDTO> orderDTOPage = orderService.listUserRentFilms(id, pageRequest);
        model.addAttribute("rentFilms", orderDTOPage);
        model.addAttribute("userId", id);
        return "viewAllUserFilms";
    }

}
