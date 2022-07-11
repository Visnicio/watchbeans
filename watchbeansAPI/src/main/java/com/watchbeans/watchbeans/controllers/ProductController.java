package com.watchbeans.watchbeans.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.watchbeans.watchbeans.models.Product;
import com.watchbeans.watchbeans.repositories.ProductRepository;


import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/produto")
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

    @RequestMapping(value = "/listar/{id}", method = RequestMethod.GET)
    public Product findProduct(@PathVariable("id") Long id) {
        return productRepository.findProduct(id);
    }

    @RequestMapping(value = "/atualizar_preco", method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product) {
        productRepository.updatePrice(product.getPrice(), product.getId());
        return "Atualizado com sucesso";
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
    public String deleteProduct(@RequestBody Product product) {
        productRepository.deleteProduct(product.getId());
        return "Deletado com sucesso";
    }

}
