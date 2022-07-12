package com.watchbeans.watchbeans.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gerente")
public class Manager {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_gerente")
    private Long id;

    @Column(name = "nome_gerente", nullable = false)
    private String name;

    @Column(name = "email_gerente", nullable = false)
    private String email;

    @Column(name = "senha_gerente", nullable = false)
    private String password;

    @Column(name = "data_cadastro", nullable = false)
    private Date createdAt;

    @Column(name = "ies_admin", nullable = false)
    private String ies_admin;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getIes_admin() {
        return ies_admin;
    }
    
    public void setIes_admin(String ies_admin) {
        this.ies_admin = ies_admin;
    }
    
    @Override
    public String toString() {
        return "Manager [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", createdAt="
                + createdAt + ", ies_admin=" + ies_admin + "]";
    }
    

}
