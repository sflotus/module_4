package org.arthur.ss3_thymeleaf.repository;

import org.arthur.ss3_thymeleaf.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getList();
    void addNew(Product product);
    boolean update(Product product);
    boolean delete(int id);
    Product getInfoById(int id);
    List<Product> search(String inputName);

}
