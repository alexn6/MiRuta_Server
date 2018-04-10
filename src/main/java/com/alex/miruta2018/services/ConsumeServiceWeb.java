/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.services;

import com.alex.miruta2018.model.support.RespPuntoMasCercano;
import com.alex.miruta2018.model.support.Url_OSRM;
import com.alex.miruta2018.support.ConvertResponseWebSrevice;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author alextc6
 */
@Service
public class ConsumeServiceWeb {
    
    private final WebClient webClient;

    public ConsumeServiceWeb(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://router.project-osrm.org/").build();
    }
        
    // cambiar String por la clase de respuesta que se va a dar
//    public Mono<String> getCoordPuntoMasCercano(String lon, String lat) {
//
//        String uriService = "nearest/v1/driving/"+lon+","+lat;
//
//        Mono<String> result = webClient.get().uri(uriService)
//                             .retrieve()
//                             .bodyToMono(String.class);
//        String response = result.block();
//        System.out.println(response);
//        return result;
//    }
        
    // cambiar String por la clase de respuesta que se va a dar
    public Mono<RespPuntoMasCercano> getCoordPuntoMasCercanoCustom(String lon, String lat) {

        String uriService = Url_OSRM.PUNTO_MAS_CERCANO +lon+","+lat;
           
        Mono<RespPuntoMasCercano> result = webClient.get().uri(uriService)
                                     .retrieve()
                                     .bodyToMono(RespPuntoMasCercano.class);
        RespPuntoMasCercano response = result.block();
            
        // sacamos el dato necesario de la info del service rest
            
        System.out.println("Lista de waypoint: "+response.getWaypoints().toString());
        System.out.println("Primer elemento de la lista: "+(response.getWaypoints().get(0).toString()));
//          System.out.println("Coord de ubicacion: "+(response.getWaypoints().get(0)));
//          System.out.println(response.getWaypoints().get(0).getClass().getName());
            
        LinkedHashMap wayp = (LinkedHashMap)response.getWaypoints().get(0);
        String ubicacion = wayp.get("location").toString();
        System.out.println(ubicacion);
            
//            String ubicacion_v1 = ubicacion.replace("[","");
//            String ubicacion_v2 = ubicacion_v1.replace("]","");
//            System.out.println(ubicacion_v2);
//            List<String> ubicacion_final = new ArrayList<String>(Arrays.asList(ubicacion_v2.split(",")));

        List<String> ubicacion_final = ConvertResponseWebSrevice.stringToCoordenate(ubicacion);

        System.out.println(ubicacion_final.get(0));
        System.out.println(ubicacion_final.get(1));
            
        System.out.println(response);
        return result;
    }
    
    public List<String> getCoordPuntoMasCercano(String lon, String lat){
        
        // se arma la url para realizar la peticion con los datos recibidos
        String uriService = Url_OSRM.PUNTO_MAS_CERCANO +lon+","+lat;
        
        Mono<RespPuntoMasCercano> result = webClient.get().uri(uriService)
                                     .retrieve()
                                     .bodyToMono(RespPuntoMasCercano.class);
        RespPuntoMasCercano response = result.block();
            
        // sacamos el dato necesario de la info del service rest
            
//        System.out.println("Lista de waypoint: "+response.getWaypoints().toString());
//        System.out.println("Primer elemento de la lista: "+(response.getWaypoints().get(0).toString()));
        
        // hacemos un casteo a la clase de mapeo para poder acceder a los atributos recibidos
        LinkedHashMap wayp = (LinkedHashMap)response.getWaypoints().get(0);
        String ubicacion = wayp.get("location").toString();
        System.out.println(ubicacion);

        List<String> ubicacion_final = ConvertResponseWebSrevice.stringToCoordenate(ubicacion);

        System.out.println(ubicacion_final.get(0));
        System.out.println(ubicacion_final.get(1));
            
        System.out.println(ubicacion_final);
        
        return ubicacion_final;
    }
       
}

