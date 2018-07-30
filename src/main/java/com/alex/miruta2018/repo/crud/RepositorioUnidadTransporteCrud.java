/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.repo.crud;

import com.alex.miruta2018.model.UnidadTransporte;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alextc6
 */
public interface RepositorioUnidadTransporteCrud extends CrudRepository<UnidadTransporte, Long>{
    Optional<UnidadTransporte> findByNombre(String nombre);
}
