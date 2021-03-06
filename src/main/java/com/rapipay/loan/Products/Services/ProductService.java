package com.rapipay.loan.Products.Services;

import com.rapipay.loan.Products.Products;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ProductService {
    @Transactional(rollbackFor = Exception.class, readOnly = false, propagation = Propagation.REQUIRED)
    String saveLoanProducts(Products loanProduct);

    Products getProduct(Integer id);

    String getCurrentTime();

    List<Products> getAllProducts();

    Products updateProduct(Integer id, Products newProduct) throws ResponseStatusException;
}
