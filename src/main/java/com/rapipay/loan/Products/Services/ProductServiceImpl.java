package com.rapipay.loan.Products.Services;

import com.rapipay.loan.Products.products;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    @Transactional(rollbackFor = Exception.class, value = "LoanDataSource", readOnly = false, propagation = Propagation.REQUIRED)
    public String saveLoanProducts(products loanProduct) {

        return "Product added successfully";
    }
}
