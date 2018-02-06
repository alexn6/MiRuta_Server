/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.interfaces;

import com.alex.miruta2018.model.Esquina;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alextc6
 */
public interface RepositorioEsquina extends CrudRepository<Esquina, Long> {
    
    Optional<Esquina> findByDescripcion(String descripcion);
    
}
