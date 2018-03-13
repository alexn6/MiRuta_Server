/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.postgis.Point;

/**
 *
 * @author alextc6
 */
@Entity(name = "esquina")
@Table(name = "esquina")
public class Esquina extends PuntoRecorrido implements Serializable{
    
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @GeneratedValue
//    private Long id;
    
    public Esquina(){
        super();
    }
    
    public Esquina(Point coordenada,int orden, String descripcion){
        super(coordenada, orden, descripcion);
    }

    public Long getId() {
        return super.getId();
    }
    
    public String getDescripcion() {
        return super.getDescripcion();
    }

    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
    }

    public Point getCoordenada() {
        return super.getCoordenada();
    }

    public void setCoordenada(Point coordenada) {
        super.setCoordenada(coordenada);
    }
    
    public int getOrden() {
        return super.getOrden();
    }

    public void setOrden(int orden) {
        super.setOrden(orden);
    }

    public Recorrido getRecorrido() {
        return super.getRecorrido();
    }

    public void setRecorrido(Recorrido recorrido) {
        super.setRecorrido(recorrido);
    }
    
    @Override
    public String toString() {
        return super.getCoordenada().toString() + " - Esquina"; //To change body of generated methods, choose Tools | Templates.
    }
}
