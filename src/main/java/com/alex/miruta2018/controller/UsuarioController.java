/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.controller;

import com.alex.miruta2018.model.Usuario;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alextc6
 */
@RestController
@RequestMapping("/miruta")
public class UsuarioController {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/users")
    public List<Usuario> all() {
        List<Usuario> users = new ArrayList<>();
        
        users.add(new Usuario("alex", "123", "algo@gmail.com"));
        users.add(new Usuario("lider", "1234", "algo1@gmail.com"));
//        users.add(new Usuario("rooney", "12345", "ron@gmail.com"));
        
        return users;
    }
    
}