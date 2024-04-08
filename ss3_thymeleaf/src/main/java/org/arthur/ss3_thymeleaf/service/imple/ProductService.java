package org.arthur.ss3_thymeleaf.service.imple;

import org.arthur.ss3_thymeleaf.model.Product;
import org.arthur.ss3_thymeleaf.repository.IProductRepo;
import org.arthur.ss3_thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo productRepo;

    @Override
    public List<Product> getList() {
        return productRepo.getList();
    }

    @Override
    public void addNew(Product product) {
        productRepo.addNew(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepo.update(product);
    }

    @Override
    public boolean delete(int id) {
       return productRepo.delete(id);
    }


    @Override
    public Product getInfoById(int id) {
        return productRepo.getInfoById(id);
    }

    @Override
    public List<Product> search(String inputName) {
        return productRepo.search(inputName);
    }
}
