package com.alwo.service.impl;

import com.alwo.exception.ResourceNotFoundException;
import com.alwo.model.Category;
import com.alwo.model.Product;
import com.alwo.repository.CategoryRepository;
import com.alwo.service.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private static final int PAGE_SIZE = 10;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(int page, Sort.Direction sort) {
        return categoryRepository.findAllCategories(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "categoryName")));
    }

    public Category getCategory(long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category " + id + " does not exist"));
    }

    @Override
    public Set<Category> getCategoriesBYNames(List<String> categoriesNames) {
        Set<Category> categories = categoryRepository.findAllByCategoryNameIn(categoriesNames);
////        List<Product> products = productRepository.findAllByCategoriesContains(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "name")), categories);

        return  categories;
    }

}
