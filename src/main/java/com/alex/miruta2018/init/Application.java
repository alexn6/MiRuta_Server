/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.init;

import com.alex.miruta2018.interfaces.RepositorioUsuarioCrud;
import com.alex.miruta2018.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author alextc6
 */
@SpringBootApplication
@EntityScan("com.alex.miruta2018.model")
// le especificamos a partir de donde buscar los controladores, servicios y componentes a instanciar
@ComponentScan(basePackages = {"com.alex.*"})
// especificamos donde se encuentran los repositorios que vamos a usar para trabajar con las entidades creadas
@EnableJpaRepositories("com.alex.miruta2018.interfaces")
// deshabilita la configuracion automatica para las rutas erroneas y con acceso restringido
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Application {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
//    ###############################################################################
//    ################################### Usuario ################################### 
    @Bean
    public CommandLineRunner cargaInicialUsuario(RepositorioUsuarioCrud repositorio) {
        return (args) -> {
//            Usuario u;
//            // encargado de hashear la contraseña
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//            // guardamos algunos usuarios
//            u = new Usuario("admin", "123", "mailalgo@gmail.com");
//            u.setPass(bCryptPasswordEncoder.encode(u.getPass()));
//            repositorio.save(u);

            // buscamos todas las paradas a modo de prueba
//            log.info("**** Usuarios encontrados con findAll(): ****");
//            for (Usuario usuario : repositorio.findAll()) {
//                log.info(usuario.toString());
//            }
//            log.info("*********************************************");
        };
    }
    
}