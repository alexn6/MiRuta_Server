/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services.support;

import com.alex.miruta2018.repo.crud.RepositorioComun;
import com.alex.miruta2018.repo.crud.RepositorioEsquina;
import com.alex.miruta2018.repo.crud.RepositorioParada;
import com.alex.miruta2018.model.Comun;
import com.alex.miruta2018.model.Esquina;
import com.alex.miruta2018.model.Parada;
import com.alex.miruta2018.model.PuntoRecorrido;
import com.alex.miruta2018.model.support.PuntoRecorridoGen;
import static com.alex.miruta2018.services.support.TiposPuntoRecorrido.COMUN;
import static com.alex.miruta2018.services.support.TiposPuntoRecorrido.ESQUINA;
import java.util.ArrayList;
import java.util.List;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alextc6
 */
public class RecorridoGenericoService {
    
//    @Autowired
//    private RepositorioEsquina repoEsquina;
//    @Autowired
//    private RepositorioComun repoComun;
//    @Autowired
//    private RepositorioParada repoParada;
    
    // se encarga de crear los tipos de puntos especificados por el cliente y en base a eso devolver la lista de puntos correspondientes
    public static List<PuntoRecorrido> getPuntosRecorrido(List<PuntoRecorridoGen> puntosCrudos){
        List<PuntoRecorrido> puntos = new ArrayList<>();
        
        for (PuntoRecorridoGen puntoCrudo : puntosCrudos) {
            puntos.add(getPuntoByTipo(puntoCrudo));
        }
        
        return puntos;
    }
    
    // crea un punto de acuerdo a su tipo
    private static PuntoRecorrido getPuntoByTipo(PuntoRecorridoGen punto){
        
        PuntoRecorrido nuevoPunto;
        Point coordenada = new Point(punto.getLat(), punto.getLon());
        String descripcion = punto.getDescripcion();
        int orden = punto.getOrden();
        
        if(punto.getTipoPunto() == COMUN){
            nuevoPunto = new Comun(coordenada, orden, descripcion);
            return nuevoPunto;
        }
        
        if(punto.getTipoPunto() == ESQUINA){
            nuevoPunto = new Esquina(coordenada, orden, descripcion);
            return nuevoPunto;
        }
        
        // sino es del tipo q queda por descarte
        nuevoPunto = new Parada(coordenada, orden, descripcion);
        return nuevoPunto;
    }
}
