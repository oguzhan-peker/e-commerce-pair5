package com.etiya.ecommercedemopair5.repositories;

import com.etiya.ecommercedemopair5.entities.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
