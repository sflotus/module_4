package org.arthur.ss3_thymeleaf.service;

import org.arthur.ss3_thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();
    void addNew(Product product);
    void update(Product product);
    void delete(int id);
    Product getInfoById(int id);
    List<Product> search(String inputName);
}
