package com.rapipay.loan.Products.Services;

import com.rapipay.loan.Products.products;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {
    @Transactional(rollbackFor = Exception.class, value = "LoanDataSource", readOnly = false, propagation = Propagation.REQUIRED)
    String saveLoanProducts(products loanProduct);
}
