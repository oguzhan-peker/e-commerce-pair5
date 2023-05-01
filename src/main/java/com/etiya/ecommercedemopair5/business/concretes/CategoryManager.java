package com.etiya.ecommercedemopair5.business.concretes;

import com.etiya.ecommercedemopair5.entities.concrete.Category;
import com.etiya.ecommercedemopair5.repositories.CategoryDao;
import com.etiya.ecommercedemopair5.business.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryDao categoryDao;

    @Override
    public void add(Category category) {
        categoryDao.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category getById(int id) {
        Optional<Category> categoryOptional = categoryDao.findById(id);
        if (categoryOptional.isPresent()) {
            Category categoryToId = categoryOptional.get();
            return categoryToId;
        }
        return null;
    }
}
