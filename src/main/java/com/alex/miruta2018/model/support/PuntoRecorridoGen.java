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
public class PuntoRecorridoGen implements Serializable{
    
    private int orden;
    private String descripcion;
    private double lat;
    private double lon;
    private int tipoPunto;
    
    public PuntoRecorridoGen(){        
    }
    
    public PuntoRecorridoGen(int orden, double lat, double lon, String descripcion, int tipo){
        this.orden = orden;
        this.lat = lat;
        this.lon = lon;
        this.descripcion = descripcion;
        this.tipoPunto = tipo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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

    public int getTipoPunto() {
        return tipoPunto;
    }

    public void setTipoPunto(int tipoPunto) {
        this.tipoPunto = tipoPunto;
    }
    
}
