package com.alwo.repository;

import com.alwo.model.ContactDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {

    @Query("select cd from ContactDetail cd")
    List<ContactDetail> findAllOrderedProduct(Pageable page);
}
