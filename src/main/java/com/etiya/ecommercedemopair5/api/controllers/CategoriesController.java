package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.entities.concrete.Category;
import com.etiya.ecommercedemopair5.business.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @PostMapping("/add")
    public void add(Category category){
        categoryService.add(category);
    }
}
