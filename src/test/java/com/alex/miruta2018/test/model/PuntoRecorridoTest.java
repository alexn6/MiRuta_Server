/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.test.model;

import com.alex.miruta2018.model.PuntoRecorrido;
import com.alex.miruta2018.test.config.ConfigTest;
import com.alex.miruta2018.test.model.PuntoRecorridoTest.TestController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.alex.miruta2018.repo.crud.RepositorioPtoRecorridoCrud;

/**
 *
 * @author alextc6
 */
@EnableJpaRepositories("com.alex.miruta2018.interfaces")
// para reconocer las anotaciones
@RunWith(SpringRunner.class)
@ContextConfiguration( classes = { TestController.class, ConfigTest.class} )
@SpringBootTest
public class PuntoRecorridoTest {
    
    public PuntoRecorridoTest(){}
    
    @Autowired
    private TestController contTest;

    
    @Test
    public void test(){
        Iterable<PuntoRecorrido> list = contTest.findAll();

        if ( list == null || !list.iterator().hasNext() ){
            Assert.fail( "No se encontraron puntos recorrido" );
        }
        else{
            for ( PuntoRecorrido ptoRecorrido : list ){
                System.out.println( "Punto comun encontrado: " + ptoRecorrido.toString());
            }
        }
        
        // son 4 xq aunqe no se hayan guardado ningun objeto Puntorecorrido recupera sus clases herencia
        assertThat(contTest.findAll())
            .hasSize(4);
        
//        System.out.println("Salto es test!!!!!");
    }
    
    
    @Component
    static class TestController{
        @Autowired
        private RepositorioPtoRecorridoCrud repo;

        /**
         * @return
         */
        public Iterable<PuntoRecorrido> findAll(){
            System.out.println("**** Puntos recorridos encontrados con findAll(): ****");

            for (PuntoRecorrido ptoRecorrido: repo.findAll()) {
                System.out.println("Puntos recorridos encontrados: "+ptoRecorrido.toString());
            }
            return repo.findAll();
        }
    }
    
}
