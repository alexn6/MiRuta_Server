/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.business;

import com.alex.miruta2018.model.Recorrido;
import com.alex.miruta2018.model.support.RecorridoCreate;
import com.alex.miruta2018.services.RecorridoService;
import java.util.NoSuchElementException;
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
@RequestMapping("/miruta/recorridos")
public class RecorridoBusiness {
    
    @Autowired
    private RecorridoService serviceRecorrido;

    
    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<Recorrido> saveRecorrido(@RequestBody RecorridoCreate recorrido) {
        Recorrido recorridoCreado = null;
        HttpStatus estadoPeticion = HttpStatus.OK;
        try {
            recorridoCreado = serviceRecorrido.create(recorrido);
        }catch (NoSuchElementException e) {
            System.err.println("ERROR al crear RECORRIDO. No existe la unidad de transporte asignada.");
            estadoPeticion = HttpStatus.BAD_REQUEST;
        }
        catch (Exception e) {
            System.err.println("ERROR al crear RECORRIDO.");
            estadoPeticion = HttpStatus.BAD_REQUEST;
        }
//        Recorrido recorridoCreado = serviceRecorrido.create(recorrido);
//        return new ResponseEntity(serviceRecorrido.create(recorrido), HttpStatus.OK);
        return new ResponseEntity(recorridoCreado, estadoPeticion);
    }
    
    @RequestMapping(value = "", method = GET)
    public ResponseEntity<Recorrido> recorridoById(@RequestParam(value = "id", required=false) Long id) {
        if(id == null){
            return new ResponseEntity(serviceRecorrido.getAll(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(serviceRecorrido.getById(id), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete", method = POST)
    public ResponseEntity deleteRecorrido(@RequestParam(value = "id") long id) {
        // ver como informar q se elimino correctamente al usuario
        serviceRecorrido.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
//    @RequestMapping(value = "/update", method = POST)
//    public ResponseEntity<Recorrido> updateRecorrido(@RequestBody RecorridoUpdate recorrido) {
//        return new ResponseEntity(serviceRecorrido.update(recorrido), HttpStatus.OK);
//    }
    
}
