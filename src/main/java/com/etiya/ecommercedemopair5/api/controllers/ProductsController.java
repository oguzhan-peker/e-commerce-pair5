package com.etiya.ecommercedemopair5.api.controllers;

import com.etiya.ecommercedemopair5.entities.concrete.Product;
import com.etiya.ecommercedemopair5.business.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @PostMapping("/add")
    public void add(Product product){
        productService.add(product);
    }

}
