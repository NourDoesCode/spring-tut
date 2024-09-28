package com.nour.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nour.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
