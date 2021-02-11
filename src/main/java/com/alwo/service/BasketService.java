package com.alwo.service;

import com.alwo.dto.BasketProductDto;
import com.alwo.model.BasketProduct;

import java.util.List;

public interface BasketService {

    List<BasketProduct> getUserBasketProducts();

    List<BasketProduct> addProductToBasket(BasketProductDto basketProductDto);

    List<BasketProduct> addLocalProductsToBasket(List<BasketProductDto> basketProductsDto);

    List<BasketProduct> editUserBasketProducts(List<BasketProductDto> editedBasketProductsDto);

    boolean deleteUserBasket();

    List<BasketProduct> deleteProductFromBasket(Long basketProductId);

    int getAmountOfBasketProducts();

    List<BasketProduct> editUserBasketProduct(BasketProductDto basketProductDto);
}
