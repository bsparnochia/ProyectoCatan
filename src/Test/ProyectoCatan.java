/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Entities.CargaGrafo.CargaInicialCaminos;
import Entities.CargaGrafo.CargaInicialUbicaciones;
import Entities.CargaLienzo.CargaLienzo;
import Entities.Cartografia.Visual.Dibujante;
import Entities.Cartografia.Coordenada;
import Entities.Cartografia.Visual.Lienzo;
import Entities.Cartografia.Loseta;
import Entities.Cartografia.Visual.ElementoLienzo;
import Entities.CargaLienzo.CargaInicialMapa;
import Entities.CargaLienzo.CargaLosetas;
import Entities.CargaLienzo.DistribuidorNumeros;
import Entities.TarjetaCostos.CargaTarjetaCostes;
import Entities.Cartografia.Cartografo;
import Entities.Cartografia.Grafo.Camino;
import Entities.Cartografia.Grafo.Grafo;
import Entities.Cartografia.Grafo.Ubicacion;
import Entities.Cartografia.Losetario;
import Entities.Juego;
import Entities.TarjetaCostos.TarjetaDeCostes;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brian
 */
public class ProyectoCatan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("HOLA CATAN 1.0!");

        //preparo la precarga de Lienzo
        CargaInicialMapa cargaMapa = new CargaInicialMapa();
        
        //Genero Lienzo
        Lienzo lienzo = cargaMapa.crearLienzo();
        //lienzo.showMapa();
        lienzo.showMapaPintado();

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
        
        
        //Genero tarjeta de costes
        CargaTarjetaCostes cargaCostes = new CargaTarjetaCostes();
        TarjetaDeCostes tarjeta = cargaCostes.generarTarjetaDeCostes();
        
        Juego catan = new Juego(cartografo,tarjeta);
    }
        
}

//herramientas visuales
//        lienzo.mostrarLienzo();
//        lienzo.showCoordenadalosetas();
//        lienzo.showIDlosetas();
//        lienzo.showIDUbicaciones();
        /*--------------------------------------------------------*/
//        Interprete interprete = new Interprete(lienzo);
//        Dibujante dibujante = new Dibujante(interprete.generarMapaArtistico());
//        Cartografo cartografo = new Cartografo
//                        (interprete.generarLosetas(), interprete.generarUbicaciones(), interprete.generarCaminos());
//        Juego catanPrueba = new Juego(cartografo, datos.generarTarjetaDeCostes(), dibujante);
        //catanPrueba.faseCreacionJugadoresPrueba();
        // catanPrueba.faseColocacion();
//        Juego catan = new Juego(master.generarMapa(),master.generarTarjetaDeCostes());
//        catan.faseCreacionJugadores();
//        catan.faseEleccionOrdenJugadores();
//        catan.faseColocacion();
//        catan.jugar();
//        catan.anunciarGanador();