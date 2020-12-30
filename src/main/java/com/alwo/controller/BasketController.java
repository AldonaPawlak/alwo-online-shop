package com.alwo.controller;

import com.alwo.model.BasketProduct;
import com.alwo.service.impl.BasketServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {

    private BasketServiceImpl basketService;

    public BasketController(BasketServiceImpl basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/{userId}/basket")
    @ResponseStatus(HttpStatus.OK)
    public List<BasketProduct> getUserBasketProducts(@PathVariable long userId){
        return basketService.getUserBasketProducts(userId);
    }

    @PostMapping("/{userId}/{productId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BasketProduct addProductToBasket(@PathVariable long userId, @PathVariable long productId){
        return basketService.addProductToBasket(userId, productId);
    }

    @PutMapping("/{userId}/basket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<BasketProduct> editUserBasketProducts(@RequestBody List<BasketProduct> basketProducts, @PathVariable Long userId){
        return basketService.editUserBasketProducts(basketProducts, userId);
    }

    @DeleteMapping("/{userId}/basket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUserBasket(@PathVariable Long userId){
        basketService.deleteUserBasket(userId);
    }

    @DeleteMapping("/{userId}/basket/{basketProductId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUserBasket(@PathVariable Long userId, @PathVariable Long basketProductId){
        basketService.deleteProductFromBasket(userId, basketProductId);
    }
}