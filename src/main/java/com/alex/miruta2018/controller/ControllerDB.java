/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.controller;

import com.alex.miruta2018.interfaces.RepositorioUsuario;
import com.alex.miruta2018.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alextc6
 */
@RestController
@RequestMapping("/miruta")
public class ControllerDB {
    
    private RepositorioUsuario repoUsuario;
	
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
//    UsuarioController(RepositorioUsuario repoUsuario, BCryptPasswordEncoder bCryptPasswordEncoder) {
    ControllerDB(RepositorioUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
//	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping("/allUsers")
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Usuario> allUsers() {
//        List<Usuario> usuarios = Lists.newArrayList( getElements() );
        return repoUsuario.findAll();
    }
    
//    @GetMapping("/users")
//    public Iterable<Usuario> getAllUsuarios() {
//        return repoUsuario.findAll();
//    }
    
}

