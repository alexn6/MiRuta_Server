/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.postgis.Geometry;
import org.postgis.Point;

/**
 *
 * @author alextc6
 */
@Entity(name = "parada")
@Table(name = "parada")
public class Parada extends PuntoRecorrido implements Serializable{
    
    // se comenta xq al haer 2 id (en esta entidad y en la superclase colisionan)
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @GeneratedValue
//    private Long id;
    
    public Parada(){
        super();
    }
    
    public Parada(Point coordenada, int orden, String descripcion){
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
        return super.getCoordenada().toString() + " - Parada"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
