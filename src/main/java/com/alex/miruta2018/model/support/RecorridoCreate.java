/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.model.support;

import java.util.List;

/**
 *
 * @author alextc6
 */
public class RecorridoCreate {
    
    private String color;
    private List<PuntoRecorridoGen> puntos;
    private long idUnidadTransporte;
    
    public RecorridoCreate(){
    }
    
    public RecorridoCreate(String color, List<PuntoRecorridoGen> puntos, long idUnidad){
        this.color = color;
        this.puntos = puntos;
        this.idUnidadTransporte = idUnidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<PuntoRecorridoGen> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<PuntoRecorridoGen> puntos) {
        this.puntos = puntos;
    }

    public long getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(long idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }
    
}
