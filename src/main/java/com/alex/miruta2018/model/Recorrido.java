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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alextc6
 */
@Entity(name = "recorrido")
@Table(name = "recorrido")
public class Recorrido implements Serializable{
    
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "recorrido")
    private List<PuntoRecorrido> puntos;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue
    private Long id;
    
    @Column(name = "color")
    private String color;
    
    // se mantiene una doble referencia con la unidad para poder realizar el ABM de recorrido
    // de una manera mas comoda, realizar cambios de unidad facilmente por ejemplo o editar recorridos ya credos
//    @OneToOne(mappedBy = "recorrido", cascade = CascadeType.ALL, 
//              fetch = FetchType.LAZY, optional = true)
    @OneToOne(mappedBy = "recorrido", cascade = CascadeType.MERGE, 
              fetch = FetchType.LAZY, optional = true)
    private UnidadTransporte unidad;
    
    public Recorrido(){
    }
    
    public Recorrido(String color, List<PuntoRecorrido> puntos, UnidadTransporte unidad){
        this.color = color;
        this.puntos = puntos;
        this.unidad = unidad;
    }
    
    public List<PuntoRecorrido> getpuntos() {
        return puntos;
    }

    public void setParadas(List<PuntoRecorrido> puntos) {
        this.puntos = puntos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public UnidadTransporte getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadTransporte unidad) {
        this.unidad = unidad;
    }
    
}
