/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.controller;

import com.alex.miruta2018.model.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import com.alex.miruta2018.interfaces.RepositorioUsuarioCrud;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alextc6
 */
@RestController
@RequestMapping("/miruta")
public class ControllerDB {
    
    private RepositorioUsuarioCrud repoUsuario;
	
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
    ControllerDB(RepositorioUsuarioCrud repoUsuario, BCryptPasswordEncoder bCryptPasswordEncoder) {
//    ControllerDB(RepositorioUsuarioCrud repoUsuario) {
        this.repoUsuario = repoUsuario;
//	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping("/allUsers")
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Usuario> allUsers() {
        return repoUsuario.findAll();
    }
    
    @RequestMapping("/user")
    public void saveUsuario(@RequestBody Usuario user) {
	user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
        repoUsuario.save(user);
    }
    
//    @RequestMapping("/login")
    @RequestMapping(value = "/login", method = GET)
    public String login() {
        return "Esta es la pagina de login";
    }
    
    @RequestMapping(value = "/create", method = GET)
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioCreado = repoUsuario.save(usuario);
        return new ResponseEntity(usuarioCreado, HttpStatus.CREATED);
    }
    
//    @PostMapping("/users/")
//    public void saveUsuario(@RequestBody Usuario user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//	usuarioRepository.save(user);
//    }
    
    @RequestMapping(value = "/users", method = GET)
    public ResponseEntity<Usuario> users() {
        Iterable<Usuario> users = repoUsuario.findAll();
        List<Usuario> list = new ArrayList<Usuario>();
        users.forEach(list::add);

        return new ResponseEntity(users, HttpStatus.OK);
    }
    
}

