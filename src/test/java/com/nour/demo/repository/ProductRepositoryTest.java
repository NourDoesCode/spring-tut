package com.nour.demo.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nour.demo.model.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED) // Prevents rollback after test
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("description of Product 1");
        product.setStock("12#re");
        product.setPrice(BigDecimal.valueOf(130));
        product.setImageUrl("product1.png");
        product.setActive(true);

        // save product
        Product savedProduct = productRepository.save(product);

        // display product info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }
}
