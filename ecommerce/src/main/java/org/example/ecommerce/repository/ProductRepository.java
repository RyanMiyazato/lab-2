package org.example.ecommerce.repository;

import org.example.ecommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();
    private Long nextId = 1L;

    public Product save(Product product) {
        product.setId(nextId++);
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void deleteById(Long id) {
        products.remove(id);
    }

    public Iterable<Product> findAll() {
        return products.values();
    }
}