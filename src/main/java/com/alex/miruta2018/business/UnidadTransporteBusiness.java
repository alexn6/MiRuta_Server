/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.business;

import com.alex.miruta2018.model.UnidadTransporte;
import com.alex.miruta2018.model.support.UnidadTransporteCreate;
import com.alex.miruta2018.model.support.UnidadTransporteUpdate;
import com.alex.miruta2018.services.UnidadTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alextc6
 */
@RestController
@RequestMapping("/miruta/unitransportes")
public class UnidadTransporteBusiness {
    
    @Autowired
    private UnidadTransporteService serviceUniTransporte;
    

    // ************************************ ABMC ************************************
    // ******************************************************************************
    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<UnidadTransporte> saveUniTransporte(@RequestBody UnidadTransporteCreate unidad) {
        return new ResponseEntity(serviceUniTransporte.create(unidad), HttpStatus.OK);
    }
    
    @RequestMapping(value = "", method = GET)
    public ResponseEntity<UnidadTransporte> uniTransporteById(@RequestParam(value = "id", required = false) Long id) {
        if(id == null){
            return new ResponseEntity(serviceUniTransporte.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity(serviceUniTransporte.getById(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete", method = POST)
    public ResponseEntity deleteUniTransporte(@RequestParam(value = "id") long id) {
        // ver como informar q se elimino correctamente al usuario
        serviceUniTransporte.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update", method = POST)
    public ResponseEntity<UnidadTransporte> updateUniTransporte(@RequestBody UnidadTransporteUpdate unidad) {
        return new ResponseEntity(serviceUniTransporte.update(unidad), HttpStatus.OK);
    }
    
    // ************************************ SOPORTE ************************************
    // *********************************************************************************
    
    @RequestMapping(value = "/names", method = GET)
    public ResponseEntity<String> nombreUniTransporte() {
        return new ResponseEntity(serviceUniTransporte.getAllNames(), HttpStatus.OK);
    }
}
