package com.alwo.service;

import com.alwo.model.BasketProduct;

import java.util.List;

public interface BasketService {

    List<BasketProduct> getUserBasketProducts(long userId);

    BasketProduct addProductToBasket(long userId, long productId);

    List<BasketProduct> editUserBasketProducts(List<BasketProduct> editedBasketProducts, Long userId);

    void deleteUserBasket(Long userId);


    void deleteProductFromBasket(Long userId, Long basketProductId);
}