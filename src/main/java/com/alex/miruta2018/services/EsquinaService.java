/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.model.Esquina;
import com.alex.miruta2018.model.support.PuntoRecorridoCreate;
import com.alex.miruta2018.model.support.PuntoRecorridoUpdate;
import java.util.ArrayList;
import java.util.List;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alex.miruta2018.repo.crud.RepositorioEsquinaCrud;

/**
 *
 * @author alextc6
 */
@Service
public class EsquinaService {
    
    @Autowired
    private RepositorioEsquinaCrud repoEsquina;
    
    public Esquina getById(long id){
        return repoEsquina.findById(id).get();
    }
    
    public List<Esquina> getAll(){
        Iterable<Esquina> esquinas = repoEsquina.findAll();
        List<Esquina> list = new ArrayList<Esquina>();
        esquinas.forEach(list::add);
        return list;
    }
    
    public Esquina create(PuntoRecorridoCreate punto){
        Esquina nuevaEsquina = new Esquina(new Point(punto.getLat(), punto.getLon()), punto.getOrden(), punto.getDescripcion());
        return repoEsquina.save(nuevaEsquina);
    }
    
    public Esquina update(PuntoRecorridoUpdate esquina){
        
        Esquina esquinaDB = repoEsquina.findById(esquina.getIdPunto()).get();
        
        esquinaDB.setCoordenada(new Point(esquina.getLat(), esquina.getLon()));
        esquinaDB.setDescripcion(esquina.getDescripcion());
        
        return repoEsquina.save(esquinaDB);
    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        // IMPORTANTE: controlar que el recorrido pierda la referencia a esta
        repoEsquina.deleteById(id);
    }
}
