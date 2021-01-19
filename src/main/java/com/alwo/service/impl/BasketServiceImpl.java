package com.alwo.service.impl;

import com.alwo.exception.ResourceNotFoundException;
import com.alwo.model.BasketProduct;
import com.alwo.model.Product;
import com.alwo.model.User;
import com.alwo.repository.BasketProductRepository;
import com.alwo.repository.ProductRepository;
import com.alwo.repository.UserRepository;
import com.alwo.service.BasketService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    private final ProductRepository productRepository;
    private final BasketProductRepository basketProductRepository;
    private final AuthServiceImpl authServiceImpl;

    public BasketServiceImpl(ProductRepository productRepository,
                             BasketProductRepository basketProductRepository,
                             AuthServiceImpl authServiceImpl) {
        this.productRepository = productRepository;
        this.basketProductRepository = basketProductRepository;
        this.authServiceImpl = authServiceImpl;
    }

    @Override
    public List<BasketProduct> getUserBasketProducts() {
        User user = authServiceImpl.getCurrentUser();
        return basketProductRepository.findAllByUser(user);
    }

    @Override
    @Transactional
    public BasketProduct addProductToBasket(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product " + productId + " not found"));
        List<BasketProduct> userBasketProducts = getUserBasketProducts();
        BasketProduct updatedBasketProduct = updateProductIfExist(userBasketProducts, productId);
        if (updatedBasketProduct != null){
            return updatedBasketProduct;
        }
        return newProductInBasket(product);
    }

    private BasketProduct updateProductIfExist(List<BasketProduct> userBasketProducts, long productId) {
        for (BasketProduct userBasketProduct : userBasketProducts) {
            if(userBasketProduct.getProduct().getId() == productId){
                userBasketProduct.setQuantity(userBasketProduct.getQuantity() + 1);
                return userBasketProduct;
            }
        }
        return null;
    }

    private BasketProduct newProductInBasket(Product product) {
        User user = authServiceImpl.getCurrentUser();
        int quantity = 1;
        return basketProductRepository.save(new BasketProduct(user, product, quantity));
    }

    @Override
    @Transactional
    public List<BasketProduct> editUserBasketProducts(List<BasketProduct> editedBasketProducts) {
        List<BasketProduct> userBasketProducts = getUserBasketProducts();
        userBasketProducts.forEach(userBasketProductToEdit -> editUserBasketProduct(userBasketProductToEdit, editedBasketProducts));
        return userBasketProducts;
    }

    private void editUserBasketProduct(BasketProduct userBasketProductToEdit, List<BasketProduct> editedBasketProducts) {
        for (BasketProduct editedBasketProduct : editedBasketProducts) {
            if(editedBasketProduct.getProduct().getId().equals(userBasketProductToEdit.getProduct().getId())){
                userBasketProductToEdit.setQuantity(editedBasketProduct.getQuantity());
                if(userBasketProductToEdit.getQuantity() <= 0){
                    basketProductRepository.delete(userBasketProductToEdit);
                }
            }
        }
    }

    @Override
    @Transactional
    public void deleteUserBasket() {
        List<BasketProduct> results = getUserBasketProducts();
        basketProductRepository.deleteAll(results);
    }

    @Override
    @Transactional
    public void deleteProductFromBasket(Long basketProductId) {
        basketProductRepository.deleteById(basketProductId);
    }
}
