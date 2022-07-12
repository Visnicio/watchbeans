package com.watchbeans.watchbeans.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watchbeans.watchbeans.models.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{
    //adicionar as querys e metodos necessarios

    //@Query("SELECT p FROM Professor p WHERE p.matricula = ?1 AND p.senha = ?2")
    //public Professor login(String matricula, String senha);

    //Aluno save(Aluno aluno);
    //uma classe que é temporaria para mandar os dados para o banco S é a classe temp e a T é a classe que esta no banco
    //<S extends T> S save(S name);
    // <newAluno extends Aluno> newAluno save(newAluno aluno);

    @Query("SELECT p FROM Manager p WHERE p.email = :email AND p.password = MD5(:password)")
    public Manager findByEmailAndPassword(@Param("email")String email, @Param("password")String password);

}
