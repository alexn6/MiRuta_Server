/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.interfaces.RepositorioUsuarioCrud;
import com.alex.miruta2018.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alextc6
 */
@Service
public class UsuarioService {
    
    @Autowired
    private RepositorioUsuarioCrud repoCrudUsuario;
    
    public Usuario getById(Long id){
        return repoCrudUsuario.findOne(id);
    }
    
    public List<Usuario> getAll(){
        Iterable<Usuario> users = repoCrudUsuario.findAll();
        List<Usuario> list = new ArrayList<Usuario>();
        users.forEach(list::add);
        return list;
    }
    
    public Usuario create(Usuario usuario){
        return repoCrudUsuario.save(usuario);
    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        repoCrudUsuario.delete(id);
    }
}