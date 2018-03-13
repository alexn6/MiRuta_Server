/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.test.model;

import com.alex.miruta2018.repo.crud.RepositorioParada;
import com.alex.miruta2018.model.Parada;
import com.alex.miruta2018.test.config.ConfigTest;
import com.alex.miruta2018.test.model.ParadaTest.TestController;
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
//@DataJpaTest
@ContextConfiguration( classes = { TestController.class, ConfigTest.class} )
//@ContextConfiguration(classes = ConfigTest.class)
@SpringBootTest
public class ParadaTest {
    
    public ParadaTest(){}
    
    @Autowired
    private TestController contTest;

    
    @Test
    public void test(){
        Iterable<Parada> list = contTest.findAll();

        if ( list == null || !list.iterator().hasNext() ){
            Assert.fail( "No se encontraron paradas" );
        }
        else{
            for ( Parada parada : list ){
                System.out.println( "Parada encontrada: " + parada.toString());
            }
        }
        
        assertThat(contTest.findAll())
            .hasSize(2);
        
//        System.out.println("Salto es test!!!!!");
    }
    
    
    @Component
    static class TestController{
        @Autowired
        private RepositorioParada repo;

        /**
         * @return
         */
        public Iterable<Parada> findAll(){
            System.out.println("**** Paradas encontradas con findAll(): ****");

            for (Parada parada : repo.findAll()) {
                System.out.println("Parada encontrado: "+parada.toString());
            }
            return repo.findAll();
        }
    }
}