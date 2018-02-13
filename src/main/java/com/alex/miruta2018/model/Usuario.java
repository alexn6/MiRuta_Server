/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotNull;

/**
 *
 * @author alextc6
 */
@Entity(name = "usuario")
@Table(name = "usuario")
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Usuario implements Serializable {
    
//    private List<Recorrido> recorrido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    @JsonIgnore
//    @JsonInclude(Include.NON_EMPTY)
    private List<PuntoInteres> ptosInteres;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "pass")
    private String pass;
    
    @Column(name = "mail")
    private String mail;
    
    public Usuario(){
        
    }
    
    public Usuario(String nombre, String pass, String mail){
        this.nombre = nombre;
        this.pass = pass;
        this.mail = mail;
        this.ptosInteres = new ArrayList<>();
//        this.recorrido = new ArrayList<>();
    }

    public long getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

//    public List<Recorrido> getRecorrido() {
//        return recorrido;
//    }
//
//    public void setRecorrido(List<Recorrido> recorrido) {
//        this.recorrido = recorrido;
//    }

    public List<PuntoInteres> getPtosInteres() {
        return ptosInteres;
    }

    public void setPtosInteres(List<PuntoInteres> ptosInteres) {
        this.ptosInteres = ptosInteres;
    }
    
    @Override
    public String toString() {
        return "Usuario " + nombre + ", mail=" + mail;
    }
    
    
}
