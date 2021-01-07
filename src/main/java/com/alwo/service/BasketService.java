package com.alwo.service;

import com.alwo.model.BasketProduct;

import java.util.List;

public interface BasketService {

    List<BasketProduct> getUserBasketProducts();

    BasketProduct addProductToBasket(long productId);

    List<BasketProduct> editUserBasketProducts(List<BasketProduct> editedBasketProducts);

    void deleteUserBasket();

    void deleteProductFromBasket(Long basketProductId);
}
