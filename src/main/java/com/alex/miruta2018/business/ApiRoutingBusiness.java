/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.business;

import com.alex.miruta2018.services.ConsumeServiceWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alextc6
 */
@RestController
@RequestMapping("/miruta/routing")
public class ApiRoutingBusiness {
    
    @Autowired
    private ConsumeServiceWeb serviceRouting;
    
    
    @RequestMapping(value = "/nearestPoint", method = GET)
    public ResponseEntity<String> getCoord(@RequestParam(value = "lon", required=false) String lon, @RequestParam(value = "lat", required=false) String lat) {
        return new ResponseEntity(serviceRouting.getCoordPuntoMasCercano(lon, lat), HttpStatus.OK);
    }
//    public ResponseEntity<String> getCoord() {
//        return new ResponseEntity(serviceRouting.getCoordPuntoMasCercano("-51.11354827880858","-30.026056381156316"), HttpStatus.OK);
//    }
    
}
