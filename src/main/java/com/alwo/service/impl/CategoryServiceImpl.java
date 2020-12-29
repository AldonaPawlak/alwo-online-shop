package com.alwo.service.impl;

import com.alwo.model.Category;
import com.alwo.repository.CategoryRepository;
import com.alwo.service.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .orElseThrow(() -> new IllegalStateException("Category " + id + " does not exist"));
    }

}
