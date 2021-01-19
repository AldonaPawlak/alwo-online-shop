package com.alwo.controller;

import com.alwo.model.BasketProduct;
import com.alwo.service.impl.BasketServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/alwo")
public class BasketController {

    private BasketServiceImpl basketService;

    public BasketController(BasketServiceImpl basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/alwo/basket")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProduct> getUserBasketProducts(){
        return basketService.getUserBasketProducts();
    }

    @PostMapping("/alwo/basket/{productId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public BasketProduct addProductToBasket(@PathVariable long productId){
        return basketService.addProductToBasket(productId);
    }

    @PutMapping("/alwo/basket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProduct> editUserBasketProducts(@RequestBody List<BasketProduct> basketProducts){
        return basketService.editUserBasketProducts(basketProducts);
    }

    @DeleteMapping("/alwo/basket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public void deleteUserBasket(){
        basketService.deleteUserBasket();
    }

    @DeleteMapping("/alwo/basket/del-product/{basketProductId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public void deleteProductBasket(@PathVariable Long basketProductId){
        basketService.deleteProductFromBasket(basketProductId);
    }
}
