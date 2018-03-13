/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.repo.crud.RepositorioEmpresa;
import com.alex.miruta2018.model.Empresa;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alextc6
 */
@Service
public class EmpresaService {
    
    @Autowired
    private RepositorioEmpresa repoEmpresa;
    
    public Empresa getById(long id){
        return repoEmpresa.findOne(id);
    }
    
    public List<Empresa> getAll(){
        Iterable<Empresa> empresas = repoEmpresa.findAll();
        List<Empresa> list = new ArrayList<Empresa>();
        empresas.forEach(list::add);
        return list;
    }
    
    public Empresa create(Empresa empresa){
        return repoEmpresa.save(empresa);
    }
    
    public Empresa update(Empresa empresa){
        return repoEmpresa.save(empresa);
    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        repoEmpresa.delete(id);
    }
    
}
