package com.watchbeans.watchbeans.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.watchbeans.watchbeans.repositories.ManagerRepository;

import com.watchbeans.watchbeans.models.Manager;


@RestController
@RequestMapping("/gerente")
@CrossOrigin(origins = "*")
public class ManagerController {
    
    @Autowired
    private ManagerRepository managerRepository;

    public ManagerController() {
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Manager manager) {
        Manager managerFound = managerRepository.findByEmailAndPassword(manager.getEmail(), manager.getPassword());
        if (managerFound != null) {
            return "Login realizado com sucesso!";
        } else {
            return "Login falhou!";
        }
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Manager> findAll() {
        return this.managerRepository.findAll();
    }

    @RequestMapping(value = "/usuario_logado", method = RequestMethod.GET)
    @ResponseBody
    public String getCurrentUserId(Principal principal) {
        return principal.getName();
    }   


    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    // public @ResponseBody Professor login(@RequestBody Professor professor){
    //     Professor professorLogin = professorRepository.login(professor.getMatricula(), professor.getSenha());
    //     return professorLogin;
    // }
}
