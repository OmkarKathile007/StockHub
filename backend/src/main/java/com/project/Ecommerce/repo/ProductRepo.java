package com.project.Ecommerce.repo;

import com.project.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    // if methods are not already there then we can customize it accordingly
    @Query("SELECT p From Product p WHERE "+
           "LOWER(p.name) LIKE LOWER (CONCAT('%' , :keyword, '%')) OR "+
           "LOWER(p.description) LIKE LOWER (CONCAT('%' , :keyword, '%')) OR "+
           "LOWER(p.brand) LIKE LOWER (CONCAT('%' , :keyword, '%')) OR "+
           "LOWER(p.category) LIKE LOWER (CONCAT('%' , :keyword, '%'))")
    List<Product> searchProducts(String keyword);
}
