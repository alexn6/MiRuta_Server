/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import org.postgis.Point;

/**
 *
 * @author alextc6
 */
public class JsonToPointDeserializer extends JsonDeserializer<Point>{
    
//    private final static GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910); 

    @Override
    public Point deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        try {
            String text = jp.getText();
            if(text == null || text.length() <= 0)
                return null;

            String[] coordinates = text.replaceFirst("POINT ?\\(", "").replaceFirst("\\)", "").split(" ");
            double lat = Double.parseDouble(coordinates[0]);
            double lon = Double.parseDouble(coordinates[1]);

            Point point = new Point(lat, lon);
            
            return point;
        }
        catch(Exception e){
            System.err.println("Hubo un error en la deserializacion del tipo de dato Point de POSTGIS");
            return null;
        }
    }
    
}
