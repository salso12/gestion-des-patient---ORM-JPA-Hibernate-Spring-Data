package com.example.tpspring.repository;

import com.example.tpspring.entities.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<product, Long> {
    List<product> findByNameContains(String ms);
}
