/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.test.model;

import com.alex.miruta2018.repo.crud.RepositorioEmpresa;
import com.alex.miruta2018.model.Empresa;
import com.alex.miruta2018.test.config.ConfigTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
@ContextConfiguration( classes = { EmpresaTest.TestController.class, ConfigTest.class} )
@SpringBootTest
public class EmpresaTest {

//    public EmpresaTest(){}
    
    @Autowired
    private TestController contTest;
    
    Empresa emp1 = new Empresa("Transport", "23-09123428-3", "transport@hotmail.com", "456271");
    Empresa emp2 = new Empresa("BusMar", "25-06123228-1", "busmar@hotmail.com", "456301");
    Empresa emp3 = new Empresa("Transport", "28-25123418-0", "pepe@hotmail.com", "450916");
    
    @Before
    public void cargaDeDatos(){
        // declaramos algunas nuevas empresas y las gaurdamos en ls DB
        contTest.saveEmpresa(emp1);
        contTest.saveEmpresa(emp2);
        contTest.saveEmpresa(emp3);
    }
    
    @Test
    public void test(){
        Iterable<Empresa> list = contTest.findAll();

        if ( list == null || !list.iterator().hasNext() ){
            Assert.fail( "No se encontraron empresas" );
        }
        else{
            for ( Empresa empresa : list ){
                System.out.println( "Empresa encontrada: " + empresa.toString());
            }
        }
        
        assertThat(contTest.findAll())
//            .hasSize(2);
            // xq se agregaron 3 empresas mas
            .hasSize(5);
//        System.out.println("Salto es test!!!!!");
    }
    
    @After
    public void borradoDatos(){
        // borramos las empresas q añadimos
        contTest.deleteEmpresa(emp1);
        contTest.deleteEmpresa(emp2);
        contTest.deleteEmpresa(emp3);
    }
    
    
    // aca declaramos todos los metodos que vamos a utilizar en el test, los cuales seran
    // accesibles por medio del controlador gral (TestController)
    @Component
    static class TestController{
        @Autowired
        private RepositorioEmpresa repo;

        /**
         * @return
         */
        public Iterable<Empresa> findAll(){
            return repo.findAll();
        }
        
        public void saveEmpresa(Empresa e){
            repo.save(e);
        }
        
        public void deleteEmpresa(Empresa e){
            repo.delete(e);
        }
    }
    
}
