package com.etiya.ecommercedemopair5.business.abstracts;

import com.etiya.ecommercedemopair5.entities.concrete.Category;

import java.util.List;

public interface CategoryService {

    void add(Category category);
    List<Category> getAll();
    Category getById(int id);

}
