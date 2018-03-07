/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.business;

import com.alex.miruta2018.model.Comun;
import com.alex.miruta2018.model.support.PuntoRecorridoCreate;
import com.alex.miruta2018.model.support.PuntoRecorridoUpdate;
import com.alex.miruta2018.services.ComunService;
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
@RequestMapping("/miruta/puntoRecorrido/comunes")
public class ComunBusiness {
    
    @Autowired
    private ComunService serviceComun;

    
    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<Comun> saveComun(@RequestBody PuntoRecorridoCreate comun) {
        return new ResponseEntity(serviceComun.create(comun), HttpStatus.OK);
    }
    
    @RequestMapping(value = "", method = GET)
    public ResponseEntity<Comun> comunById(@RequestParam(value = "id", required=false) Long id) {
        if(id == null){
            return new ResponseEntity(serviceComun.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity(serviceComun.getById(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete", method = POST)
    public ResponseEntity deleteComun(@RequestParam(value = "id") long id) {
        // ver como informar q se elimino correctamente al usuario
        serviceComun.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update", method = POST)
    public ResponseEntity<Comun> updateComun(@RequestBody PuntoRecorridoUpdate comun) {
        return new ResponseEntity(serviceComun.update(comun), HttpStatus.OK);
    }
    
}
