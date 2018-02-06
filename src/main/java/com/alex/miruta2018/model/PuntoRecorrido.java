/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.postgis.Point;

/**
 *
 * @author alextc6
 */
@Entity(name = "puntorecorrido")
@Table(name = "puntorecorrido")
// crea una nueva tabla por cada subclase, se unen los atributos de las 2 clases
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class PuntoRecorrido implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue
    private Long id;
    
    @Column(name = "coordenada")
    private Point coordenada;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    // los recorridos no son solo de las unidades de transporte, puede ser con puntos q no sean paradas
    @JoinColumn(name="Recorrido_ID", nullable = true)
    private Recorrido recorrido;
    
    public PuntoRecorrido(){        
    }
    
    public PuntoRecorrido(Point coordenada, String descripcion){
        this.descripcion = descripcion;
        this.coordenada = coordenada;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Point getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }
    
    @Override
    public String toString() {
        return this.coordenada.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
