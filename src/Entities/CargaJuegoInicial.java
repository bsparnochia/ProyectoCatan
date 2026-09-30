/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.CargaInicial.CargaGrafo.CargaInicialCaminos;
import Entities.CargaInicial.CargaGrafo.CargaInicialUbicaciones;
import Entities.CargaInicial.CargaLienzo.CargaInicialMapa;
import Entities.Cartografia.Cartografo;
import Entities.Cartografia.Grafo.Camino;
import Entities.Cartografia.Grafo.Grafo;
import Entities.Cartografia.Grafo.Ubicacion;
import Entities.Cartografia.Losetario;
import Entities.Cartografia.Visual.Lienzo;
import Entities.CargaInicial.TarjetaCostos.CargaTarjetaCostes;
import Entities.CargaInicial.TarjetaCostos.TarjetaDeCostes;
import java.util.List;

/**
 * Entidad encargada de organizar las operaciones iniciales de carga de datos para preparar el juego
 * @author Brian
 */
public class CargaJuegoInicial {
    
    public Juego generarConfiguracionInicialJuego(){
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
        CargaInicialUbicaciones cargaUbicaciones= new CargaInicialUbicaciones(lienzo);
        List<Ubicacion> ubicaciones = cargaUbicaciones.generarListadoUbicaciones();
        //cargaUbicaciones.mostrarListadoUbicaciones(); OK
        
        CargaInicialCaminos cargaCaminos = new CargaInicialCaminos(ubicaciones,lienzo);
        List<Camino> caminos = cargaCaminos.generarListadoCaminos();
        //cargaCaminos.mostrarListadoCaminos(); OK
        
        
        Grafo grafo = new Grafo(ubicaciones,caminos);
        //grafo.mostrarVertices();
        //grafo.mostrarAristas();
        
        //Genero cartografo con Lienzo, Losetario y Grafo
        Cartografo cartografo = new Cartografo(grafo, lienzo, losetario);
        cartografo.mostrarMapa();
        
        
        //Genero tarjeta de costes
        CargaTarjetaCostes cargaCostes = new CargaTarjetaCostes();
        TarjetaDeCostes tarjeta = cargaCostes.generarTarjetaDeCostes();
        
        return new Juego(cartografo,tarjeta);
    }
    
}
