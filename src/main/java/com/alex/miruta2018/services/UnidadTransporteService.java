/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.interfaces.RepositorioEmpresa;
import com.alex.miruta2018.interfaces.RepositorioUnidadTransporte;
import com.alex.miruta2018.model.Empresa;
import com.alex.miruta2018.model.UnidadTransporte;
import com.alex.miruta2018.model.support.UnidadTransporteCreate;
import com.alex.miruta2018.model.support.UnidadTransporteUpdate;
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
    private RepositorioEmpresa repoEmpresa;
    
    public UnidadTransporte getById(long id){
        return repoUniTransporte.findOne(id);
    }
    
    public List<UnidadTransporte> getAll(){
        Iterable<UnidadTransporte> unidades = repoUniTransporte.findAll();
        List<UnidadTransporte> list = new ArrayList<UnidadTransporte>();
        unidades.forEach(list::add);
//        System.out.println("Unidades obtenidas: "+list.size());
        return list;
    }
    
    public UnidadTransporte create(UnidadTransporteCreate unidad){
        Empresa emp = repoEmpresa.findOne(unidad.getIdEmpresa());
        UnidadTransporte nuevaUnidad = new UnidadTransporte(unidad.getNombre(), LocalTime.of(unidad.getHoraInicio(), unidad.getMinInicio()), LocalTime.of(unidad.getHoraFin(), unidad.getMinFin()), unidad.getFrecuencia(), unidad.getPrecioBoleto(), emp);
        System.out.println("idUniTransporte creado: "+nuevaUnidad.getId());
        return repoUniTransporte.save(nuevaUnidad);
    }
    
    public UnidadTransporte update(UnidadTransporteUpdate unidad){
        // asegurar desde el cliente que estos campos correspondan siempre a datos existentes
        UnidadTransporte unidadDB = repoUniTransporte.findOne(unidad.getId());
        Empresa emp = repoEmpresa.findOne(unidad.getIdEmpresa());
        
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
        repoUniTransporte.delete(id);
    }
}
