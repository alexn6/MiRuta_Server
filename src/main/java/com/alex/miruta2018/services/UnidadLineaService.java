/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.model.Empresa;
import com.alex.miruta2018.model.UnidadLinea;
import com.alex.miruta2018.model.support.UnidadTransporteCreate;
import com.alex.miruta2018.model.support.UnidadTransporteUpdate;
import com.alex.miruta2018.repo.crud.RepositorioEmpresaCrud;
import com.alex.miruta2018.repo.crud.RepositorioUnidadLineaCrud;
import com.alex.miruta2018.repo.queries.RepositorioUnidadLineaJpa;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alextc6
 */
@Service
public class UnidadLineaService {
    
    @Autowired
    private RepositorioUnidadLineaCrud repoUniLinea;
    @Autowired
    private RepositorioUnidadLineaJpa repoUniTransporteQueries;
    @Autowired
    private RepositorioEmpresaCrud repoEmpresa;
    
    
    // ************************************ ABMC ************************************
    // ******************************************************************************
    
    public UnidadLinea getById(long id){
        return repoUniLinea.findById(id).get();
    }
    
    public List<UnidadLinea> getAll(){
        Iterable<UnidadLinea> unidades = repoUniLinea.findAll();
        List<UnidadLinea> list = new ArrayList<>();
        unidades.forEach(list::add);
        return list;
    }
    
    public UnidadLinea create(UnidadTransporteCreate unidad){
        Empresa emp = repoEmpresa.findById(unidad.getIdEmpresa()).get();
        UnidadLinea nuevaUnidad = new UnidadLinea(unidad.getNombre(), LocalTime.of(unidad.getHoraInicio(), unidad.getMinInicio()), LocalTime.of(unidad.getHoraFin(), unidad.getMinFin()), unidad.getFrecuencia(), unidad.getPrecioBoleto(), emp);
        System.out.println("idUniTransporte creado: "+nuevaUnidad.getId());
        return repoUniLinea.save(nuevaUnidad);
    }
    
    public UnidadLinea update(UnidadTransporteUpdate unidad){
        // asegurar desde el cliente que estos campos correspondan siempre a datos existentes
        UnidadLinea unidadDB = repoUniLinea.findById(unidad.getId()).get();
        Empresa emp = repoEmpresa.findById(unidad.getIdEmpresa()).get();
        
        unidadDB.setNombre(unidad.getNombre());
        unidadDB.setHoraInicio(LocalTime.of(unidad.getHoraInicio(), unidad.getMinInicio()));
        unidadDB.setHoraFin(LocalTime.of(unidad.getHoraFin(), unidad.getMinFin()));
        unidadDB.setFrecuencia(unidad.getFrecuencia());
        unidadDB.setPrecioBoleto(unidad.getPrecioBoleto());
        unidadDB.setEmpresa(emp);
        
        return repoUniLinea.save(unidadDB);
    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        repoUniLinea.deleteById(id);
    }
    
    
    // ************************************ SOPORTE ************************************
    // *********************************************************************************
    
    public List<String> getAllNames(){
        return repoUniTransporteQueries.findAllNames();
    }
    
}
