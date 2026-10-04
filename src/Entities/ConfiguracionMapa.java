/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.CargaInicial.CargaLienzo.CargaInicialMapa;
import Entities.CargaInicial.CargaGrafo.CargaInicialCaminos;
import Entities.CargaInicial.CargaGrafo.CargaInicialUbicaciones;
import Entities.Cartografia.Cartografo;
import Entities.Cartografia.Grafo.Camino;
import Entities.Cartografia.Grafo.Grafo;
import Entities.Cartografia.Grafo.Ubicacion;
import Entities.Cartografia.Losetario;
import Entities.Cartografia.Visual.Lienzo;
import java.util.List;

/**
 * Entidad encargada de organizar las operaciones iniciales de carga de datos para preparar el juego
 * @author Brian
 */
public class ConfiguracionMapa {
        private static final int NO_DEFINIDO = 0;
    
    
        /**----------------- CREACION DEL MAPA ----------------- **/

    /**
     * Configura y prepara el mapa inicial del juego
     * @return 
     */
    public Cartografo configurarMapa(){
        System.out.println("HOLA CATAN 0.5!");

        //preparo la precarga de Lienzo
        CargaInicialMapa cargaMapa = new CargaInicialMapa();
        
        //Genero Lienzo
        Lienzo lienzo = cargaMapa.crearLienzo();
        //lienzo.showMapa();
        //lienzo.showMapaPintado();

        //Genero Losetario
        Losetario losetario = cargaMapa.crearLosetario();
        //losetario.showLosetasGeneradas();
        
        //Genero Grafo
        //---UBICACIONES---
        CargaInicialUbicaciones cargaUbicaciones= new CargaInicialUbicaciones(lienzo);
        List<Ubicacion> ubicaciones = cargaUbicaciones.generarListadoUbicaciones();
        //cargaUbicaciones.mostrarListadoUbicaciones(); OK
        
        //---CAMINOS---
        CargaInicialCaminos cargaCaminos = new CargaInicialCaminos(ubicaciones,lienzo);
        List<Camino> caminos = cargaCaminos.generarListadoCaminos();
        //cargaCaminos.mostrarListadoCaminos(); OK
        
        
        Grafo grafo = new Grafo(ubicaciones,caminos);
        //grafo.mostrarVertices();
        //grafo.mostrarAristas();
        
        //Genero cartografo con Lienzo, Losetario y Grafo
        return new Cartografo(grafo, lienzo, losetario);
    }
  
    

}
