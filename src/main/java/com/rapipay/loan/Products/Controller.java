package com.rapipay.loan.Products;

import com.rapipay.loan.Products.Services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

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
    public String addLoanProduct(@RequestBody Products loanProduct) {
        return productService.saveLoanProducts(loanProduct);
    }

    @RequestMapping(method = RequestMethod.GET, value="getProduct")
    public Products getProduct(@RequestParam Integer id) {
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.PATCH,value ="updateProduct/{id}")
    public Products updateProduct(@PathVariable Integer id, @RequestBody(required = false) Products product) {
        return productService.updateProduct(id,product);
    }
}
