package com.alwo.controller;

import com.alwo.model.BasketProduct;
import com.alwo.service.impl.BasketServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {

    private BasketServiceImpl basketService;

    public BasketController(BasketServiceImpl basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/users/{userId}/basket")
    public List<BasketProduct> getUserBasketProducts(@PathVariable long userId){
        return basketService.getUserBasketProducts(userId);
    }

    @PostMapping("/users/{userId}/basket/{productId}")
    public BasketProduct addProductToBasket(@PathVariable long userId, @PathVariable long productId){
        return basketService.addProductToBasket(userId, productId);
    }

    @PutMapping("/users/{userId}/basket")
    public List<BasketProduct> editUserBasketProducts(@RequestBody List<BasketProduct> basketProducts, @PathVariable Long userId){
        return basketService.editUserBasketProducts(basketProducts, userId);
    }

    @DeleteMapping("/users/{userId}/basket")
    public void deleteUserBasket(@PathVariable Long userId){
        basketService.deleteUserBasket(userId);
    }
}