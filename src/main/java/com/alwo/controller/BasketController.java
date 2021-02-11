package com.alwo.controller;

import com.alwo.dto.BasketProductDto;
import com.alwo.dto.DtoMapper;
import com.alwo.model.BasketProduct;
import com.alwo.service.impl.BasketServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/alwo")
public class BasketController {

    private BasketServiceImpl basketService;
    private DtoMapper dtoMapper;

    public BasketController(BasketServiceImpl basketService,
                            DtoMapper dtoMapper) {
        this.basketService = basketService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/alwo/basket")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProductDto> getUserBasketProducts(){
        return dtoMapper.mapToBasketProductDtos(basketService.getUserBasketProducts());
    }

    @GetMapping("/alwo/basket/amount")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public int getAmountOfBasketProducts(){
        return basketService.getAmountOfBasketProducts();
    }

//    return dtoMapper.mapToProductDtos(productService.getProducts(pageNumber, sortDirection));

    @PostMapping("/alwo/basket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProductDto> addProductToBasket(@RequestBody BasketProductDto basketProductDto) {
        return dtoMapper.mapToBasketProductDtos(basketService.addProductToBasket(basketProductDto));
    }



    @PostMapping("/alwo/basket/products")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProductDto> addLocalProductsToBasket(@RequestBody List<BasketProductDto> basketProductsDto) {
        return dtoMapper.mapToBasketProductDtos(basketService.addLocalProductsToBasket(basketProductsDto));
    }

    @PutMapping("/alwo/basket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProduct> editUserBasketProducts(@RequestBody List<BasketProductDto> basketProductsDto){
        return basketService.editUserBasketProducts(basketProductsDto);
    }

    @PutMapping("/alwo/basket/product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProductDto> editUserBasketProduct(@RequestBody BasketProductDto basketProductDto){
        return dtoMapper.mapToBasketProductDtos(basketService.editUserBasketProduct(basketProductDto));
    }

    @DeleteMapping("/alwo/basket")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public boolean deleteUserBasket(){
        return basketService.deleteUserBasket();
    }

    @DeleteMapping("/alwo/basket/del-product/{basketProductId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    public List<BasketProductDto> deleteProductBasket(@PathVariable Long basketProductId){
        return dtoMapper.mapToBasketProductDtos(basketService.deleteProductFromBasket(basketProductId));
    }
}
