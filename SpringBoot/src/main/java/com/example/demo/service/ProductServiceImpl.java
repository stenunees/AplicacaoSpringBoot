package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getId().equals(id)) {
                product.setId(id);
                products.set(i, product);
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
