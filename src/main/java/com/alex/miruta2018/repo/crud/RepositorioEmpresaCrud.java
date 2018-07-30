/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.repo.crud;

import com.alex.miruta2018.model.Empresa;
import com.alex.miruta2018.model.Parada;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alextc6
 */
public interface RepositorioEmpresaCrud extends CrudRepository<Empresa, Long>{
    Optional<Parada> findByNombre(String nombre);
}
