package com.rapipay.loan.Products.Repository;

import com.rapipay.loan.Products.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {

    void addProduct(Products products);

    void updateProduct(Products products);

    Products getProductById(Integer id);

    List<Products> getAllProduct();


}
    

