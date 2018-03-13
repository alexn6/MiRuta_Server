/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.repo.crud;

import com.alex.miruta2018.model.Parada;
import com.alex.miruta2018.model.Recorrido;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alextc6
 */
public interface RepositorioRecorrido extends CrudRepository<Recorrido, Long>{
    Optional<Recorrido> findByColor(String color);
}
