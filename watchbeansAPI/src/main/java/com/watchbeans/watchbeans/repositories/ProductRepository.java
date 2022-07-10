package com.watchbeans.watchbeans.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watchbeans.watchbeans.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    <newProduct extends Product> newProduct save(newProduct product);

    @Modifying
    @Transactional
    @Query(value = "UPDATE produto SET preco_produto = :newPrice WHERE cod_produto = :id", nativeQuery = true)
    public void updatePrice(@Param("newPrice")Float price, @Param("id")Long id);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM produto WHERE cod_produto = :id", nativeQuery = true)
    public void deleteProduct(@Param("id")Long id);

    @Query(value = "SELECT * FROM produto WHERE cod_produto = :id", nativeQuery = true)
    public Product findProduct(@Param("id")Long id);
}
