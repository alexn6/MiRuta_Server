/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.test.model;

import com.alex.miruta2018.model.Usuario;
import com.alex.miruta2018.test.config.ConfigTest;
import com.alex.miruta2018.test.model.UsuarioTest.TestController;
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
import com.alex.miruta2018.interfaces.RepositorioUsuarioCrud;

/**
 *
 * @author alextc6
 */
@EnableJpaRepositories("com.alex.miruta2018.interfaces")
// para reconocer las anotaciones
@RunWith(SpringRunner.class)
@ContextConfiguration( classes = { TestController.class, ConfigTest.class} )
@SpringBootTest
public class UsuarioTest {
    
    public UsuarioTest(){}
    
    @Autowired
    private TestController contTest;
    
    @Test
    public void test(){
        Iterable<Usuario> list = contTest.findAll();

        if ( list == null || !list.iterator().hasNext() ){
            Assert.fail( "No se encontraron usuarios" );
        }
        else{
            for ( Usuario usuario : list ){
                System.out.println( "Usuario encontrado: " + usuario.toString());
            }
        }
        
        assertThat(contTest.findAll())
            .hasSize(2);
//        System.out.println("Salto es test!!!!!");
    }
    
    @Component
    static class TestController{
        @Autowired
        private RepositorioUsuarioCrud repo;

        /**
         * @return
         */
        public Iterable<Usuario> findAll(){
            return repo.findAll();
        }
    }
}
