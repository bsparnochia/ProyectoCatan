/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia;

import Entities.Cartografia.Visual.Mapa;
import Entities.Cartografia.Loseta;
import Entities.Cartografia.Ubicacion;
import Entities.Cartografia.Camino;
import Enumerados.Construccion;
import Enumerados.ColorJugador;
import Enumerados.Recurso;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Brian
 */
public class Cartografo {
    List<Ubicacion> listaLugares;
    List<Camino> listaCaminos;
    List<Loseta> listaLozetas;
    Mapa mapa;
    Loseta LosetaLadron;

    public Cartografo(List<Loseta> generarLosetas, List<Ubicacion> generarUbicaciones, List<Camino> generarCaminos) { //provisorio para hacer test, luego borrar
    }

    
    
    public Cartografo(List<Ubicacion> listaLugares, List<Camino> listaCaminos, List<Loseta> listaLozetas, Loseta LosetaLadron) {
        this.listaLugares = listaLugares;
        this.listaCaminos = listaCaminos;
        this.listaLozetas = listaLozetas;
        this.LosetaLadron = LosetaLadron;
    }

    
    public void mostrarMapa(){
        System.out.println("***TEST MAPA***");
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Recurso getRecursoSegunUbicacion(int dados){
        Recurso r= Recurso.TRIGO; //terminar, esta hecho basico para que funcione para probar codigo
        return r;
    }

    public boolean ubicacionEstaOcupada(int fila, int columna) {
        int idUbicacion = this.mapa.getIdXcoordenada(fila, columna);
        return this.buscarUbicacionPorId(idUbicacion).estaOcupada();
    }
   
    private Ubicacion buscarUbicacionPorId(int id){
        Iterator <Ubicacion> iterador = this.listaLugares.iterator();
        boolean encontrado = false;
                    
        Ubicacion actual = iterador.next();
        while (iterador.hasNext() && !encontrado){

            if ( this.esLaMismaId(actual.getId(), id)){
                encontrado=true;
            }
        }
        return actual;
    }
    
    private boolean esLaMismaId(int a, int b){
        return a==b;
    }

    public void ocuparUbicacion(int numeroJugador, int fila, int columna) {
        int idUbicacion = this.mapa.getIdXcoordenada(fila, columna);
        Ubicacion actual = buscarUbicacionPorId(idUbicacion);
        
        actual.setConstruccion(Construccion.POBLADO);
        actual.setDueño(numeroJugador);
    }
}

    
