package com.alwo.service;

import com.alwo.model.Category;
import com.alwo.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<Category> getCategories(int page, Sort.Direction sort);

    Category getCategory(long id);

    Set<Category> getCategoriesBYNames(List<String> categoriesNames);

    Category addCategory(Category category);

    void deleteCategory(long id);
}
