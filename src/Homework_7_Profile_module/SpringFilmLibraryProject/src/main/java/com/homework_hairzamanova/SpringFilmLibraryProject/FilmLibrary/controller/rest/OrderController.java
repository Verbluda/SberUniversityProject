package com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller.rest;

import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.controller.rest.GenericController;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.dto.OrderDTO;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.model.Order;
import com.homework_hairzamanova.SpringFilmLibraryProject.FilmLibrary.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Заказы", description = "Контроллер для работы с заказами из фильмотеки")
public class OrderController extends GenericController<Order, OrderDTO> {
    public OrderController(OrderService orderService) {
        super(orderService);
    }

    @Operation(description = "Список заказов пользователя по ID")
    @RequestMapping(value = "userOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDTO>> getOrdersByUserId(@RequestParam(value = "userId") Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(((OrderService) service).getUserOrders(userId));
    }
}