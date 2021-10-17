package com.rapipay.loan.Products.Services;

import com.rapipay.loan.Products.Repository.ProductRepository;
import com.rapipay.loan.Products.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String saveLoanProducts(Products loanProduct) {
        loanProduct.setCreatedOn(getCurrentTime());
        loanProduct.setUpdatedOn(getCurrentTime());
        loanProduct.setIsActive(true);
        productRepository.saveAndFlush(loanProduct);
        return "Product added successfully";
    }

    @Override
    public Products getProduct(Integer id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Products updateProduct(Integer id,Products newProduct) throws ResponseStatusException {

        if(!productRepository.existsById(id))
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"No product with the given productId"
            );
        }
        else{
            Products product = productRepository.getOne(id);
            if(newProduct.getProductName()!=null){
                product.setProductName(newProduct.getProductName());
            }
            if(newProduct.getPrincipleAmount()!=null){
                product.setPrincipleAmount(newProduct.getPrincipleAmount());
            }
            if(newProduct.getTenure()!=null){
                product.setTenure(newProduct.getTenure());
            }
            if(newProduct.getRoi()!=null){
                product.setRoi(newProduct.getRoi());
            }
            if(newProduct.getUpdatedBy()!=null){
                product.setUpdatedBy(newProduct.getUpdatedBy());
            }
            product.setUpdatedOn(getCurrentTime());

            productRepository.updateProduct(product);

            return  product;
        }

    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
