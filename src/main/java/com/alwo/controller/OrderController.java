package com.alwo.controller;

import com.alwo.dto.OrderDataDto;
import com.alwo.dto.OrderResponseDto;
import com.alwo.model.Order;
import com.alwo.service.BasketService;
import com.alwo.service.OrderService;
import com.alwo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;
    private BasketService basketService;
    private UserService userService;

    public OrderController(OrderService orderService, BasketService basketService, UserService userService) {
        this.orderService = orderService;
        this.basketService = basketService;
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    @GetMapping("/alwo/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDto> getUserOrders(){
        return orderService.getUserOrders();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    @GetMapping("/alwo/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getUserOrder(@PathVariable long id){
        return orderService.getUserOrder(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    @PostMapping("/alwo/orders")
    public void addOrder(@RequestBody OrderDataDto orderDataDto) {
        orderService.createNewOrder(orderDataDto);
    }

    // ONLY ADMIN

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/admin/alwo/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page>= 0 ? page:0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return orderService.getOrders(pageNumber, sortDirection);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/admin/alwo/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable long id) {
        return orderService.getOrder(id);
    }

}
