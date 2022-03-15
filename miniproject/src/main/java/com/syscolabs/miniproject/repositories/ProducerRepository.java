package com.syscolabs.miniproject.repositories;

import com.syscolabs.miniproject.entities.Producer;
import com.syscolabs.miniproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

}
