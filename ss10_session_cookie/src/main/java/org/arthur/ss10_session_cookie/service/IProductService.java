package org.arthur.ss10_session_cookie.service;

import org.arthur.ss10_session_cookie.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);
}
