package org.arthur.ss10_session_cookie.service.impl;

import org.arthur.ss10_session_cookie.model.Product;
import org.arthur.ss10_session_cookie.repository.IProductRepository;
import org.arthur.ss10_session_cookie.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
