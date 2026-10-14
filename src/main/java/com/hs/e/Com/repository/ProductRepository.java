package com.hs.e.Com.repository;

import com.hs.e.Com.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}