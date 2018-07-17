/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.repo.crud.RepositorioRecorrido;
import com.alex.miruta2018.repo.crud.RepositorioUnidadTransporte;
import com.alex.miruta2018.model.PuntoRecorrido;
import com.alex.miruta2018.model.Recorrido;
import com.alex.miruta2018.model.UnidadTransporte;
import com.alex.miruta2018.model.support.RecorridoCreate;
import com.alex.miruta2018.services.support.RecorridoGenericoService;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alextc6
 */
@Service
public class RecorridoService {
    
    @Autowired
    private RepositorioRecorrido repoRecorrido;
    @Autowired
    private RepositorioUnidadTransporte repoUniTransporte;
    
    public Recorrido getById(long id){
        return repoRecorrido.findById(id).get();
    }
    
    public List<Recorrido> getAll(){
        Iterable<Recorrido> recorridos = repoRecorrido.findAll();
        List<Recorrido> list = new ArrayList<Recorrido>();
        recorridos.forEach(list::add);
        return list;
    }
    
    public Recorrido create(RecorridoCreate recorrido) throws NoSuchElementException{
        List<PuntoRecorrido> puntos = RecorridoGenericoService.getPuntosRecorrido(recorrido.getPuntos());
        
        UnidadTransporte unidad = repoUniTransporte.findById(recorrido.getIdUnidadTransporte()).get();
        Recorrido nuevoRecorrido = new Recorrido(recorrido.getColor(), puntos, unidad);

        return nuevoRecorrido;
    }
    
//    public Recorrido update(RecorridoCreate comun){
//        
//        Recorrido comunDB = repoRecorrido.findOne(comun.getIdPunto());
//        
//        comunDB.setCoordenada(new Point(comun.getLat(), comun.getLon()));
//        comunDB.setDescripcion(comun.getDescripcion());
//        
//        return repoRecorrido.save(comunDB);
//    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        // IMPORTANTE: controlar que el recorrido pierda la referencia a esta
        repoRecorrido.deleteById(id);
    }
    
}
