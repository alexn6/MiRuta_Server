/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.test.model;

import com.alex.miruta2018.interfaces.RepositorioComun;
import com.alex.miruta2018.model.Comun;
import com.alex.miruta2018.test.config.ConfigTest;
import com.alex.miruta2018.test.model.ComunTest.TestController;
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

/**
 *
 * @author alextc6
 */
@EnableJpaRepositories("com.alex.miruta2018.interfaces")
// para reconocer las anotaciones
@RunWith(SpringRunner.class)
@ContextConfiguration( classes = { TestController.class, ConfigTest.class} )
@SpringBootTest
public class ComunTest {
    
    public ComunTest(){}
    
    @Autowired
    private TestController contTest;

    
    @Test
    public void test(){
        Iterable<Comun> list = contTest.findAll();

        if ( list == null || !list.iterator().hasNext() ){
            Assert.fail( "No se encontraron puntos comunes" );
        }
        else{
            for ( Comun comun : list ){
                System.out.println( "Punto comun encontrado: " + comun.toString());
            }
        }
        
        assertThat(contTest.findAll())
            .hasSize(1);
        
//        System.out.println("Salto es test!!!!!");
    }
    
    
    @Component
    static class TestController{
        @Autowired
        private RepositorioComun repo;

        /**
         * @return
         */
        public Iterable<Comun> findAll(){
            System.out.println("**** Puntos comun encontrados con findAll(): ****");

            for (Comun comun : repo.findAll()) {
                System.out.println("Esquina encontrada: "+comun.toString());
            }
            return repo.findAll();
        }
    }
    
}
