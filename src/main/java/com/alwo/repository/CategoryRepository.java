package com.alwo.repository;

import com.alwo.model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c")
    List<Category> findAllCategories(Pageable page);

    Set<Category> findAllByCategoryNameIn(Collection<String> categoryName);

}
