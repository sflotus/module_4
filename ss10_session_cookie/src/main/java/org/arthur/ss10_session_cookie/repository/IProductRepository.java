package org.arthur.ss10_session_cookie.repository;

import org.arthur.ss10_session_cookie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
