/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.business;

import com.alex.miruta2018.interfaces.RepositorioUsuarioCrud;
import com.alex.miruta2018.model.Usuario;
import com.alex.miruta2018.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alextc6
 */
@RestController
@RequestMapping("/miruta")
public class UsuarioBusiness {
    
    @Autowired
    private UsuarioService serviceUsuario;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @RequestMapping(value = "/users", method = GET)
    public ResponseEntity<Usuario> allUsers() {
        return new ResponseEntity(serviceUsuario.getAll(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/createUser", method = POST)
    public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
	usuario.setPass(bCryptPasswordEncoder.encode(usuario.getPass()));
        return new ResponseEntity(serviceUsuario.create(usuario), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user", method = GET)
    public ResponseEntity<Usuario> userById(@RequestParam(value = "id") long id) {
        return new ResponseEntity(serviceUsuario.getById(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deteteUser", method = POST)
    public ResponseEntity deleteUser(@RequestParam(value = "id") long id) {
        // ver como informar q se elimino correctamente al usuario
        serviceUsuario.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
