package com.nour.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nour.demo.model.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

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

    @Test
    void updateUsingSaveMethod() {
        // find or retrieve an entity by id
        Long id = 3L;
        Product product = productRepository.findById(id).get();
        // update entity information
        product.setName("updated product  1");
        product.setDescription("updated description");
        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 3L;
        Product product = productRepository.findById(id).get();

    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED) // Prevents rollback after test
    @Test
    void saveAllMethod() {
        // create product1
        Product product = new Product();
        product.setName("Product 2");
        product.setDescription("description of Product 1");
        product.setStock("zee44");
        product.setPrice(BigDecimal.valueOf(100));
        product.setImageUrl("product2.png");
        product.setActive(false);

        // create product2
        Product product3 = new Product();
        product3.setName("Product3");
        product3.setDescription("description of Product3 ");
        product3.setStock("f3ef44");
        product3.setPrice(BigDecimal.valueOf(780));
        product3.setImageUrl("product3.png");
        product3.setActive(true);

        productRepository.saveAll(List.of(product, product3));
    }
}
