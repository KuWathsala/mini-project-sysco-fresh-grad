package com.syscolabs.miniproject.repositories;

import com.syscolabs.miniproject.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByName(String prductName);
    public List<Product> findByNameContaining(String prductName);
}
