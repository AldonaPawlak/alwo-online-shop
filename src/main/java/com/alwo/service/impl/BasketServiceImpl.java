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
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private BasketProductRepository basketProductRepository;
    private AuthServiceImpl authServiceImpl;

    public BasketServiceImpl(ProductRepository productRepository,
                             UserRepository userRepository,
                             BasketProductRepository basketProductRepository,
                             AuthServiceImpl authServiceImpl) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.basketProductRepository = basketProductRepository;
        this.authServiceImpl = authServiceImpl;
    }

    @Override
    public List<BasketProduct> getUserBasketProducts() {
        User user = authServiceImpl.getCurrentUser();
        System.out.println(user);
        return basketProductRepository.findAllByUser(user);
    }

    @Override
    @Transactional
    public BasketProduct addProductToBasket(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product " + productId + " not found"));
        List<BasketProduct> userBasketProducts = getUserBasketProducts();

        for (BasketProduct userBasketProduct : userBasketProducts) {
            if(userBasketProduct.getProduct().getId() == productId){
                userBasketProduct.setQuantity(userBasketProduct.getQuantity() + 1);
                userBasketProduct.setTotalPrice(userBasketProduct.getProduct().getPrice() * userBasketProduct.getQuantity());
                return userBasketProduct;
            }
        }
        User user = authServiceImpl.getCurrentUser();
        int quantity = 1;
        double totalPrice = product.getPrice() * quantity;
        return basketProductRepository.save(new BasketProduct(user, product, quantity, totalPrice));
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
                userBasketProductToEdit.setTotalPrice(userBasketProductToEdit.getTotalPrice() * userBasketProductToEdit.getQuantity());
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
