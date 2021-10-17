package com.rapipay.loan.Products.Repository;

import com.rapipay.loan.Products.Products;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
abstract class ProductRepositoryImpl implements ProductRepository {

    private RedisTemplate template;
    private HashOperations hash;

    private String HASHCCODE = "Product";


    public ProductRepositoryImpl(RedisTemplate<String,Products> template) {
        this.template = template;
        hash = template.opsForHash();
    }

    @Override
    public void addProduct(Products product) {
        hash.put(HASHCCODE, product.getProductId(),product);
        saveAndFlush(product);

    }

    @Override
    public Products getProductById(Integer id){
        Products product = (Products) hash.get(HASHCCODE,id);
        if(product==null || product.getProductName()==null) {
            return findById(id).orElse(new Products());
        } else {
            return product;
        }

    }

    @Override
    public List<Products> getAllProduct(){
        Map<String,Products> products = hash.entries(HASHCCODE);
        return products.isEmpty() ? findAll() : new ArrayList<>(products.values());
    }

    @Override
    public void updateProduct(Products product) {
        hash.put(HASHCCODE, product.getProductId(),product);
        save(product);
    }
}
