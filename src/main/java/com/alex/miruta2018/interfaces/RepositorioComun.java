/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.interfaces;

import com.alex.miruta2018.model.Comun;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alextc6
 */
public interface RepositorioComun extends CrudRepository<Comun, Long>{
    
    Optional<Comun> findByDescripcion(String descripcion);
    
}
