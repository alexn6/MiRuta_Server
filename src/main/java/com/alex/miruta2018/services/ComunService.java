/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.model.Comun;
import com.alex.miruta2018.model.support.PuntoRecorridoCreate;
import com.alex.miruta2018.model.support.PuntoRecorridoUpdate;
import com.alex.miruta2018.repo.queries.RepositorioUnidadTransporteJpa;
import java.util.ArrayList;
import java.util.List;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alex.miruta2018.repo.crud.RepositorioComunCrud;

/**
 *
 * @author alextc6
 */
@Service
public class ComunService {
    
    @Autowired
    private RepositorioComunCrud repoComun;
    @Autowired
    private RepositorioUnidadTransporteJpa repo;
    
    public Comun getById(long id){
        return repoComun.findById(id).get();
    }
    
    public List<Comun> getAll(){
        Iterable<Comun> comunes = repoComun.findAll();
        List<Comun> list = new ArrayList<Comun>();
        comunes.forEach(list::add);
        return list;
    }
    
    public Comun create(PuntoRecorridoCreate punto){
        Comun nuevaComun = new Comun(new Point(punto.getLat(), punto.getLon()), punto.getOrden(), punto.getDescripcion());
        return repoComun.save(nuevaComun);
    }
    
    public Comun update(PuntoRecorridoUpdate comun){
        
        Comun comunDB = repoComun.findById(comun.getIdPunto()).get();
        
        comunDB.setCoordenada(new Point(comun.getLat(), comun.getLon()));
        comunDB.setDescripcion(comun.getDescripcion());
        
        return repoComun.save(comunDB);
    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        // IMPORTANTE: controlar que el recorrido pierda la referencia a esta
        repoComun.deleteById(id);
    }
}
