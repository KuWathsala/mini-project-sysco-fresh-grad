package com.syscolabs.miniproject.repositories;

import com.syscolabs.miniproject.entities.Category;
import com.syscolabs.miniproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
