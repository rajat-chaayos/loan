package com.rapipay.loan.Products;

import com.rapipay.loan.Products.Services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/")
public class Controller {


    @Autowired
    public ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "addLoanProduct")
    public String addLoanProduct(@RequestBody products loanProduct) {
        return productService.saveLoanProducts(loanProduct);
    }
}
