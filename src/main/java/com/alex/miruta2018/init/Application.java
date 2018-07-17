/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.miruta2018.init;

import com.alex.miruta2018.model.Comun;
import com.alex.miruta2018.model.Empresa;
import com.alex.miruta2018.model.Esquina;
import com.alex.miruta2018.model.Parada;
import com.alex.miruta2018.model.PuntoInteres;
import com.alex.miruta2018.model.PuntoRecorrido;
import com.alex.miruta2018.model.Recorrido;
import com.alex.miruta2018.model.UnidadTransporte;
import com.alex.miruta2018.repo.crud.RepositorioUsuarioCrud;
import com.alex.miruta2018.model.Usuario;
import com.alex.miruta2018.repo.crud.RepositorioComun;
import com.alex.miruta2018.repo.crud.RepositorioEmpresa;
import com.alex.miruta2018.repo.crud.RepositorioEsquina;
import com.alex.miruta2018.repo.crud.RepositorioParada;
import com.alex.miruta2018.repo.crud.RepositorioPtoInteres;
import com.alex.miruta2018.repo.crud.RepositorioRecorrido;
import com.alex.miruta2018.repo.crud.RepositorioUnidadTransporte;
import com.alex.miruta2018.repo.queries.RepositorioUsuarioJpa;
import com.alex.miruta2018.services.ConsumeServiceWeb;
import com.alex.miruta2018.services.EmpresaService;
import com.alex.miruta2018.services.UsuarioService;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.postgis.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author alextc6
 */
@SpringBootApplication
@EntityScan("com.alex.miruta2018.model")
// le especificamos a partir de donde buscar los controladores, servicios y componentes a instanciar
@ComponentScan(basePackages = {"com.alex.*"})
// especificamos donde se encuentran los repositorios que vamos a usar para trabajar con las entidades creadas
@EnableJpaRepositories(basePackages = {"com.alex.miruta2018.repo.*"})
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
    public CommandLineRunner cargaInicialUsuario(UsuarioService service) {
        return (args) -> {
//            Usuario u;
//            // guardamos algunos usuarios
//            u = new Usuario(1L, "admin", "123", "mailalgo@gmail.com");
//            service.create(u);
//            
//            u = new Usuario(2L, "alex", "111", "mail");
//            service.create(u);
//
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Usuarios encontrados con findAll(): ****");
//            for (Usuario usuario : service.getAll()) {
//                log.info(usuario.toString());
//            }
//            log.info("*********************************************");
        };
    }
    
//    ####################################################################################
//    ##################################### Empresa ######################################
    @Bean
    public CommandLineRunner cargaInicialEmpresas(EmpresaService service) {
        return (args) -> {
//            Empresa emp;
//            
//            emp = new Empresa(1L, "Benitez", "23-23456789-2", "benitez@gmail.com", "4474536");
//            service.create(emp);
//            log.info("Se creo la empresa BENITEZ");
//            
//            emp = new Empresa(2L, "Ceferino", "25-23251789-0", "ceferino@gmail.com", "4471256");
//            service.create(emp);
//            log.info("Se creo la empresa CEFERINO");
//
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Empresas guardadas: ****");
//            for (Empresa empresa : service.getAll()) {
//                log.info(empresa.toString());
//            }
//            log.info("*********************************************");
        };
    }
    
//    ####################################################################################
//    ############################ Unidad de transportes #################################
    @Bean
    public CommandLineRunner cargaInicialUnidadTransporte(RepositorioUnidadTransporte repoUniTransporte, RepositorioEmpresa repoEmpresa) {
        return (args) -> {
//            UnidadTransporte unidad;
//            unidad = new UnidadTransporte("Unidad1", LocalTime.of(8, 0), LocalTime.of(22, 0), 20, 9.50f, repoEmpresa.findById(3L).get());
//            repoUniTransporte.save(unidad);
//            
//            unidad = new UnidadTransporte("Unidad2", LocalTime.of(7, 30), LocalTime.of(22, 15), 15, 11.00f, repoEmpresa.findById(4L).get());
//            repoUniTransporte.save(unidad);
//
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Unidades de transporte guardadas: ****");
//            for (UnidadTransporte unidadT : repoUniTransporte.findAll()) {
//                log.info(unidadT.toString());
//            }
//            log.info("*********************************************");
        };
    }
    
//    ####################################################################################
//    ################################### PuntoInteres ###################################
    @Bean
    public CommandLineRunner cargaInicialPtoInteres(RepositorioPtoInteres repoPtoInteres, RepositorioUsuarioCrud repoUsuario) {
        return (args) -> {
//            PuntoInteres ptoInt;
//            // guardamos algunos puntos
//            ptoInt = new PuntoInteres("ranchoLider", new Point(-65.0435781612698, -42.76403644138906), repoUsuario.findById(1L).get());
//            repoPtoInteres.save(ptoInt);
//            ptoInt = new PuntoInteres("unRanchito", new Point(-65.04562200453915, -42.75792890613414), repoUsuario.findById(2L).get());
//            repoPtoInteres.save(ptoInt);
//
//
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Punto de Interes encontrados con findAll(): ****");
//            for (PuntoInteres punto : repoPtoInteres.findAll()) {
//                log.info(punto.toString());
//            }
//            log.info("*********************************************");
        };
    }

//    ####################################################################################
//    ##################################### Parada ######################################
    // anotacion para indicar que se ejecute este procedimiento
    // CommandLineRunner: para correr algún código específico al arranque de la aplicación con Spring Boot
    @Bean
    public CommandLineRunner cargaInicialParada(RepositorioParada repositorio) {
        return (args) -> {
//            Parada p;
//            // guardamos algunas paradas
//            p = new Parada(new Point(-65.0435781612698, -42.76403644138906), 1, "ranchoLider");
//            repositorio.save(p);
//            p = new Parada(new Point(-65.04562200453915, -42.75792890613414), 2, "unRanchito");
//            repositorio.save(p);
//
//
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Paradas encontradas con findAll(): ****");
//            for (Parada parada : repositorio.findAll()) {
//                log.info(parada.toString());
//            }
//            log.info("********************************************");
	};
    }
    
//    ####################################################################################
//    ##################################### Esquina y comun ######################################
    @Bean
    public CommandLineRunner cargaInicialEsquinaComun(RepositorioEsquina repoEsquina, RepositorioComun repoComun) {
        return (args) -> {
//            Esquina puntoEsq;
//            Comun puntoComun;
//            
//            puntoEsq = new Esquina(new Point(-65.03970639255681, -42.76892813211024), 3, "esquina1");
//            repoEsquina.save(puntoEsq);
//            
//            puntoComun = new Comun(new Point(-65.03639654663243, -42.76895963634532), 4, "punto comun");
//            repoComun.save(puntoComun);
//
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Esquina guardadas: ****");
//            for (Esquina esquina : repoEsquina.findAll()) {
//                log.info(esquina.toString());
//            }
//            
//            log.info("*********************************************");
//            
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Puntos comun guardados: ****");
//            for (Comun ptoComun : repoComun.findAll()) {
//                log.info(ptoComun.toString());
//            }
//            log.info("*********************************************");
        };
    }
    
//    ######################################################################################
//    ##################################### Recorrido ######################################
    @Bean
    public CommandLineRunner cargaInicialRecorrido(RepositorioRecorrido repoRecorrido, RepositorioEsquina repoEsquina,
                                        RepositorioParada repoParada, RepositorioUnidadTransporte repoUniTRansporte,
                                        RepositorioComun repoComun) {
        return (args) -> {
//            Recorrido reco;
//            PuntoRecorrido ptoRecorrido;
//            Parada parada;
//            List<PuntoRecorrido> paradas = new ArrayList<>();
//            
//            // *********** creamos un recorrido buscando puntos ya creados *************
//            paradas.add(repoParada.findById(9L).get());
//            paradas.add(repoParada.findById(10L).get());
//            paradas.add(repoEsquina.findById(11L).get());
//            paradas.add(repoComun.findById(12L).get());
//            
//            reco = new Recorrido("blanco", paradas, repoUniTRansporte.findById(5L).get());
//            repoRecorrido.save(reco);
//            log.info("Se creo el recorrido 1, con puntos ya guardados: "+reco.toString());
//            
//            // *********** creamos un recorrido buscando puntos nuevos *************
//            ptoRecorrido = new Parada(new Point(-42.77347646555213, -65.04964397695699), 5, "p1");
//            paradas.add(ptoRecorrido);
//            ptoRecorrido = new Parada(new Point(-42.77303150153067, -65.04829214361348), 6, "p2");
//            paradas.add(ptoRecorrido);
//            ptoRecorrido = new Parada(new Point(-42.772598347642486, -65.0469993188683), 7, "p3");
//            paradas.add(ptoRecorrido);
//            ptoRecorrido = new Esquina(new Point(-42.77214943950719, -65.04572795179524), 8, "esquina 1");
//            paradas.add(ptoRecorrido);
//            ptoRecorrido = new Comun(new Point(-42.76980246330086, -65.0503306224648), 9, "punto comun 2");
//            paradas.add(ptoRecorrido);
//            ptoRecorrido = new Comun(new Point(-42.769349596918005, -65.0491236284081), 10, "pto comun 3");
//            paradas.add(ptoRecorrido);
//            ptoRecorrido = new Esquina(new Point(-42.7688140289225, -65.048565728933), 11, "esquina 2");
//            paradas.add(ptoRecorrido);
//
//            reco = new Recorrido("gris", paradas, repoUniTRansporte.findById(6L).get());
//            repoRecorrido.save(reco);
//            log.info("Se creo el recorrido 2, con nuevos puntos: "+reco.toString());
//
//            // buscamos todas las paradas a modo de prueba
//            log.info("**** Recorridos encontrados con findAll(): ****");
//            for (Recorrido recorrido : repoRecorrido.findAll()) {
//                log.info(recorrido.toString());
//            }
//            log.info("********************************************");
	};
    }
    
    //    ###############################################################################
//    ################################### TEST CONSUME API ################################### 
    @Bean
    public CommandLineRunner testServiceWeb(ConsumeServiceWeb service) {
        return (args) -> {
            
            System.out.println("############################ Testing del API de RUTAS ############################");
            System.out.println("##################################################################################");
            
            service.getCoordPuntoMasCercano("-51.11354827880858","-30.026056381156316");
//            service.getCoordPuntoMasCercanoCustom("-51.11354827880858","-30.026056381156316");
            
            String lon1 = "-51.07714";
            String lat1 = "-29.993041";
            String lon2 = "-51.077202";
            String lat2 = "-29.989399";
//            service.getRuta(lon1, lat1, lon2, lat2);
        };
    }
    
}