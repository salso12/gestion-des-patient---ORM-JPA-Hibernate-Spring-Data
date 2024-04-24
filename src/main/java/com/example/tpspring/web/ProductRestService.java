package com.example.tpspring.web;

import com.example.tpspring.entities.product;
import com.example.tpspring.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public List<product> products(){
            return productRepo.findAll();
    }
    @GetMapping("/products/{id}")
    public product findProductById(@PathVariable Long id){
        return productRepo.findById(id).get();
    }
}
