package com.watchbeans.watchbeans.repositories;

import javax.persistence.Lob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watchbeans.watchbeans.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    <newProduct extends Product> newProduct save(newProduct product);
}
