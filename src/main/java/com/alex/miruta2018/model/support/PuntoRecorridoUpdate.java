/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.model.support;

import java.io.Serializable;

/**
 *
 * @author alextc6
 */
public class PuntoRecorridoUpdate implements Serializable{
    
    private long idPunto;
    private String descripcion;
    private double lat;
    private double lon;
    
    public PuntoRecorridoUpdate(){        
    }
    
    public PuntoRecorridoUpdate(long idPunto, double lat, double lon, String descripcion){
        this.idPunto = idPunto;
        this.lat = lat;
        this.lon = lon;
        this.descripcion = descripcion;
    }

    public long getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(long idPunto) {
        this.idPunto = idPunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
    
}
