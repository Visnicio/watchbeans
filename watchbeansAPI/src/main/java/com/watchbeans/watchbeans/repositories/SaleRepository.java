package com.watchbeans.watchbeans.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.watchbeans.watchbeans.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
    
    //TODO - create the insert and update methods

    <newSale extends Sale> newSale save(newSale sale);


    //essa lógica talvez nao seja aplicada como "adicionar produto" pois só altera o valor da venda sem ter conjunto com o valor do produto, e nem aplica o código da venda ao produto
    //talvez dê de fazer isso pelo front onde ele faz uma requisição da venda para atualizar o preco e no produto para atualizar o cod_venda
    //mas o melhor seria fazer aqui.
    //escrever a lógica da venda
    @Modifying
    @Transactional
    @Query(value = "UPDATE venda SET valor_venda = :newPrice WHERE cod_venda = :id", nativeQuery = true)
    public void updatePrice(@Param("newPrice")Float price, @Param("id")Long id);

    @Query(value = "INSERT INTO venda(status) VALUES (:status)", nativeQuery = true)
    public Sale insertSale(@Param("status")String status);


}
