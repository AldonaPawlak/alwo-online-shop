package com.alwo.service.impl;

import com.alwo.dto.BasketProductDto;
import com.alwo.exception.ResourceNotFoundException;
import com.alwo.model.BasketProduct;
import com.alwo.model.Product;
import com.alwo.model.User;
import com.alwo.repository.BasketProductRepository;
import com.alwo.repository.ProductRepository;
import com.alwo.service.BasketService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public List<BasketProduct> editUserBasketProduct(BasketProductDto basketProductDto) {
        List<BasketProduct> userBasketProducts = getUserBasketProducts();
        BasketProduct updatedBasketProduct = updateBasketProductIfExist(userBasketProducts, basketProductDto);
        if (updatedBasketProduct != null && updatedBasketProduct.getQuantity() > 0){
            return userBasketProducts;
        } else if (updatedBasketProduct != null && updatedBasketProduct.getQuantity() <= 0)
            basketProductRepository.delete(updatedBasketProduct);
        userBasketProducts = getUserBasketProducts();
        return userBasketProducts;
    }

    private BasketProduct updateBasketProductIfExist(List<BasketProduct> userBasketProducts, BasketProductDto basketProductDto) {
        for (BasketProduct userBasketProduct : userBasketProducts) {
            if(userBasketProduct.getProduct().getId().equals(basketProductDto.getProductId())){
                userBasketProduct.setQuantity(basketProductDto.getQuantity());
                return userBasketProduct;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public List<BasketProduct> addProductToBasket(BasketProductDto basketProductDto) {
        Product product = productRepository.findById(basketProductDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product " + basketProductDto.getProductId() + " not found"));
        BasketProduct updatedBasketProduct = updateProductIfExist(basketProductDto);
        if (updatedBasketProduct != null){
            return getUserBasketProducts();
        }
        newProductInBasket(product, basketProductDto.getQuantity());
        return getUserBasketProducts();
    }


    @Override
    @Transactional
    public List<BasketProduct> addLocalProductsToBasket(List<BasketProductDto> basketProductsDto) {
        for (BasketProductDto basketProductDto : basketProductsDto) {
            BasketProduct updatedBasketProduct = updateProductIfExist(basketProductDto);
            if (updatedBasketProduct == null) {
                Product product = productRepository.findById(basketProductDto.getProductId())
                        .orElseThrow(() -> new ResourceNotFoundException("Product " + basketProductDto.getProductId() + " not found"));
                newProductInBasket(product, basketProductDto.getQuantity());
            }
        }
        return getUserBasketProducts();
    }


    private BasketProduct updateProductIfExist(BasketProductDto basketProductDto) {
        List<BasketProduct> userBasketProducts = getUserBasketProducts();
        for (BasketProduct userBasketProduct : userBasketProducts) {
            if(userBasketProduct.getProduct().getId().equals(basketProductDto.getProductId())){
                userBasketProduct.setQuantity(userBasketProduct.getQuantity() + basketProductDto.getQuantity());
                return userBasketProduct;
            }
        }
        return null;
    }

    private void newProductInBasket(Product product, int quantity) {
        User user = authServiceImpl.getCurrentUser();
        basketProductRepository.save(new BasketProduct(user, product, quantity));
    }

    @Override
    @Transactional
    public List<BasketProduct> editUserBasketProducts(List<BasketProductDto> editedBasketProductsDto) {
        List<BasketProduct> userBasketProducts = getUserBasketProducts();
        userBasketProducts.forEach(userBasketProductToEdit -> editUserBasketProduct(userBasketProductToEdit, editedBasketProductsDto));
        return userBasketProducts;
    }

    public void editUserBasketProduct(BasketProduct userBasketProductToEdit, List<BasketProductDto> editedBasketProductsDto) {
        for (BasketProductDto editedBasketProductDto : editedBasketProductsDto) {
            if(editedBasketProductDto.getProductId().equals(userBasketProductToEdit.getProduct().getId())){
                userBasketProductToEdit.setQuantity(editedBasketProductDto.getQuantity());
                if(userBasketProductToEdit.getQuantity() <= 0){
                    basketProductRepository.delete(userBasketProductToEdit);
                }
            }
        }
    }

    @Override
    @Transactional
    public boolean deleteUserBasket() {
        List<BasketProduct> results = getUserBasketProducts();
        basketProductRepository.deleteAll(results);
        if (getUserBasketProducts().isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public List<BasketProduct> deleteProductFromBasket(Long basketProductId) {
        basketProductRepository.deleteById(basketProductId);
        return getUserBasketProducts();
    }

    @Override
    public int getAmountOfBasketProducts() {
        List<BasketProduct> basketProducts = getUserBasketProducts();
        return basketProducts.stream()
                .mapToInt(BasketProduct::getQuantity)
                .sum();
    }


}
