/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.model.Parada;
import com.alex.miruta2018.model.support.PuntoRecorridoCreate;
import com.alex.miruta2018.model.support.PuntoRecorridoUpdate;
import java.util.ArrayList;
import java.util.List;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alex.miruta2018.repo.crud.RepositorioParadaCrud;

/**
 *
 * @author alextc6
 */
@Service
public class ParadaService {
    
    @Autowired
    private RepositorioParadaCrud repoParada;
    
    public Parada getById(long id){
        return repoParada.findById(id).get();
    }
    
    public List<Parada> getAll(){
        Iterable<Parada> paradas = repoParada.findAll();
        List<Parada> list = new ArrayList<Parada>();
        paradas.forEach(list::add);
        return list;
    }
    
    public Parada create(PuntoRecorridoCreate parada){
        Parada nuevaParada = new Parada(new Point(parada.getLat(), parada.getLon()), parada.getOrden(), parada.getDescripcion());
        return repoParada.save(nuevaParada);
    }
    
    public Parada update(PuntoRecorridoUpdate parada){
        
        Parada paradaDB = repoParada.findById(parada.getIdPunto()).get();
        
        paradaDB.setCoordenada(new Point(parada.getLat(), parada.getLon()));
        paradaDB.setDescripcion(parada.getDescripcion());
        
        return repoParada.save(paradaDB);
    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        // IMPORTANTE: controlar que el recorrido pierda la referencia a esta
        repoParada.deleteById(id);
    }
}
