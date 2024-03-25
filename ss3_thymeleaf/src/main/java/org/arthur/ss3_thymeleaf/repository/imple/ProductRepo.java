package org.arthur.ss3_thymeleaf.repository.imple;

import org.arthur.ss3_thymeleaf.model.Product;
import org.arthur.ss3_thymeleaf.repository.IProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Chuoi",10000,"Chuoi VN","VN"));
        productList.add(new Product(2,"Xoai",20000,"Xoai VN","VN"));
        productList.add(new Product(3,"Cam",15000,"Cam CN","CN"));
        productList.add(new Product(4,"Quyt",5000,"Quyt JP","Jp"));
        productList.add(new Product(5,"Thanh Long",10000,"Thanh Long CN","CN"));
    }
    @Override
    public List<Product> getList() {
        return productList;
    }

    @Override
    public void addNew(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product getInfoById(int id) {
        return null;
    }

    @Override
    public List<Product> search(String inputName) {
        return null;
    }
}
