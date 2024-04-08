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
    public boolean update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==product.getId()){
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setName(product.getName());
                productList.get(i).setDesc(product.getDesc());
                productList.get(i).setOrigin(product.getOrigin());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for(int i=0;i<productList.size();i++){
            if(productList.get(i).getId()==id){
                productList.remove(productList.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public Product getInfoById(int id) {
        for(Product product:productList){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> search(String inputName) {
        return null;
    }
}
