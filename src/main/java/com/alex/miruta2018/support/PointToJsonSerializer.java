/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.postgis.Point;

/**
 *
 * @author alextc6
 */
public class PointToJsonSerializer extends JsonSerializer<Point>{
    
    @Override
    public void serialize(Point value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {

        String jsonValue = "null";
        try
        {
            if(value != null) {             
                double lat = value.getY();
                double lon = value.getX();
                jsonValue = String.format("POINT (%s %s)", lat, lon);
            }
        }
        catch(Exception e) {
            System.err.println("Hubo un error en la serializacion del tipo de dato Point de POSTGIS");
        }

        jgen.writeString(jsonValue);
    }
}
