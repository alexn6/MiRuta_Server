/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.business;

import com.alex.miruta2018.model.Esquina;
import com.alex.miruta2018.model.support.PuntoRecorridoCreate;
import com.alex.miruta2018.model.support.PuntoRecorridoUpdate;
import com.alex.miruta2018.services.EsquinaService;
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
@RequestMapping("/miruta/puntoRecorrido/esquinas")
public class EsquinaBusiness {
    
    @Autowired
    private EsquinaService serviceEsquina;

    
    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<Esquina> saveEsquina(@RequestBody PuntoRecorridoCreate esquina) {
        return new ResponseEntity(serviceEsquina.create(esquina), HttpStatus.OK);
    }
    
    @RequestMapping(value = "", method = GET)
    public ResponseEntity<Esquina> esquinaById(@RequestParam(value = "id", required=false) Long id) {
        if(id == null){
            return new ResponseEntity(serviceEsquina.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity(serviceEsquina.getById(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete", method = POST)
    public ResponseEntity deleteEsquina(@RequestParam(value = "id") long id) {
        // ver como informar q se elimino correctamente al usuario
        serviceEsquina.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update", method = POST)
    public ResponseEntity<Esquina> updateEsquina(@RequestBody PuntoRecorridoUpdate esquina) {
        return new ResponseEntity(serviceEsquina.update(esquina), HttpStatus.OK);
    }
}
