package com.rapipay.loan.Products.Repository;

import com.rapipay.loan.Products.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface ProductRepository extends JpaRepository<Products, Integer> {


}
    

