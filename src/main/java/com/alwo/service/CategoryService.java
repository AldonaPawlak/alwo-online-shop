package com.alwo.service;

import com.alwo.model.Category;
import com.alwo.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories(int page, Sort.Direction sort);

    Category getCategory(long id);


}