package com.watchbeans.watchbeans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.watchbeans.watchbeans.models.Product;
import com.watchbeans.watchbeans.repositories.ProductRepository;


import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    public ProductController() {
    }

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld(){
        return "Estamos no ar mesmo?";
    }

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

}
