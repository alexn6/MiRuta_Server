/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.test.model;

import com.alex.miruta2018.repo.crud.RepositorioEmpresa;
import com.alex.miruta2018.model.Empresa;
import com.alex.miruta2018.test.config.ConfigTest;
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
@ContextConfiguration( classes = { DatosEmpresaTest.TestController.class, ConfigTest.class} )
@SpringBootTest
public class DatosEmpresaTest {
    
    @Autowired
    private TestController contTest;
    
    Empresa emp = new Empresa("USA", "21-01125424-0", "usa@hotmail.com", "453471");

    @Before
    public void cargaDeDatos(){
        // se guarda una nueva empresa
        contTest.saveEmpresa(emp);
    }
    
    @Test
    public void test(){
        System.out.println("id de la empresa: "+emp.getId());
//        Empresa e = contTest.findById(emp.getId());
        
        Empresa e = contTest.finByNombre(emp.getNombre());
        
        if(e != null){
            Assert.assertEquals("USA", e.getNombre());
            Assert.assertEquals("21-01125424-0", e.getCuit());
            Assert.assertEquals("usa@hotmail.com", e.getMail());
            Assert.assertEquals("453471", e.getTelefono());
        }
        else
            System.out.println("No se encontro la empresa indicada.");
    }
    
    @After
    public void borradoDatos(){
        // se guarda una nueva empresa
        contTest.deleteEmpresa(emp);
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
        public Empresa findById(Long id){
            return repo.findOne(id);
        }
        
        public void saveEmpresa(Empresa e){
            repo.save(e);
        }
        
        public void deleteEmpresa(Empresa e){
            repo.delete(e);
        }
        
        public Empresa finByNombre(String nombre){
            Iterable<Empresa> empresas = repo.findAll();
            Empresa e = null;
            for ( Empresa empresa : empresas ){
                if(empresa.getNombre().equals(nombre))
                    e = empresa;
            }
            return e;
        }
    }
}
