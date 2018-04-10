/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.repo.crud.RepositorioEmpresa;
import com.alex.miruta2018.repo.crud.RepositorioUnidadTransporte;
import com.alex.miruta2018.model.Empresa;
import com.alex.miruta2018.model.UnidadTransporte;
import com.alex.miruta2018.model.support.UnidadTransporteCreate;
import com.alex.miruta2018.model.support.UnidadTransporteUpdate;
import com.alex.miruta2018.repo.queries.RepositorioUnidadTransporteJpa;
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
public class UnidadTransporteService {
    
    @Autowired
    private RepositorioUnidadTransporte repoUniTransporte;
    @Autowired
    private RepositorioUnidadTransporteJpa repoUniTransporteQueries;
    
    @Autowired
    private RepositorioEmpresa repoEmpresa;
    
    
    // ************************************ ABMC ************************************
    // ******************************************************************************
    
    public UnidadTransporte getById(long id){
        return repoUniTransporte.findById(id).get();
    }
    
    public List<UnidadTransporte> getAll(){
        Iterable<UnidadTransporte> unidades = repoUniTransporte.findAll();
        List<UnidadTransporte> list = new ArrayList<>();
        unidades.forEach(list::add);
        return list;
    }
    
    public UnidadTransporte create(UnidadTransporteCreate unidad){
        Empresa emp = repoEmpresa.findById(unidad.getIdEmpresa()).get();
        UnidadTransporte nuevaUnidad = new UnidadTransporte(unidad.getNombre(), LocalTime.of(unidad.getHoraInicio(), unidad.getMinInicio()), LocalTime.of(unidad.getHoraFin(), unidad.getMinFin()), unidad.getFrecuencia(), unidad.getPrecioBoleto(), emp);
        System.out.println("idUniTransporte creado: "+nuevaUnidad.getId());
        return repoUniTransporte.save(nuevaUnidad);
    }
    
    public UnidadTransporte update(UnidadTransporteUpdate unidad){
        // asegurar desde el cliente que estos campos correspondan siempre a datos existentes
        UnidadTransporte unidadDB = repoUniTransporte.findById(unidad.getId()).get();
        Empresa emp = repoEmpresa.findById(unidad.getIdEmpresa()).get();
        
        unidadDB.setNombre(unidad.getNombre());
        unidadDB.setHoraInicio(LocalTime.of(unidad.getHoraInicio(), unidad.getMinInicio()));
        unidadDB.setHoraFin(LocalTime.of(unidad.getHoraFin(), unidad.getMinFin()));
        unidadDB.setFrecuencia(unidad.getFrecuencia());
        unidadDB.setPrecioBoleto(unidad.getPrecioBoleto());
        unidadDB.setEmpresa(emp);
        
        return repoUniTransporte.save(unidadDB);
    }
    
    // ver si mandar algun mje cuando se elimina correctamente
    public void delete(Long id){
        repoUniTransporte.deleteById(id);
    }
    
    
    // ************************************ SOPORTE ************************************
    // *********************************************************************************
    
    public List<String> getAllNames(){
        return repoUniTransporteQueries.findAllNames();
    }
}
