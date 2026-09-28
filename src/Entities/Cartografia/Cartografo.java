/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia;

import Entities.Cartografia.Grafo.Grafo;
import Entities.Cartografia.Visual.Lienzo;


/**
 *
 * @author Brian
 */
public class Cartografo {
    private Grafo grafo;
    private Losetario losetario;
    private Lienzo lienzo;    

    public Cartografo(Grafo grafo, Lienzo lienzo, Losetario losetario) {
        this.grafo = grafo;
        this.losetario = losetario;
        this.lienzo = lienzo;
    }
    
    

    
    public void mostrarMapa(){
        this.lienzo.showMapaPintado();
    }

//    public Recurso getRecursoSegunTirada(int dados){
//        Recurso r= Recurso.TRIGO; //terminar, esta hecho basico para que funcione para probar codigo
//        return r;
//    }

//    public boolean ubicacionEstaOcupada(int fila, int columna) {
//        int idUbicacion = this.mapa.getIdXcoordenada(fila, columna);
//        return this.buscarUbicacionPorId(idUbicacion).estaOcupada();
//    }
//   
//    private Ubicacion buscarUbicacionPorId(int id){
//        Iterator <Ubicacion> iterador = this.listaLugares.iterator();
//        boolean encontrado = false;
//                    
//        Ubicacion actual = iterador.next();
//        while (iterador.hasNext() && !encontrado){
//
//            if ( this.esLaMismaId(actual.getId(), id)){
//                encontrado=true;
//            }
//        }
//        return actual;
//    }
//    
//    private boolean esLaMismaId(int a, int b){
//        return a==b;
//    }
//
//    public void ocuparUbicacion(int numeroJugador, int fila, int columna) {
//        int idUbicacion = this.mapa.getIdXcoordenada(fila, columna);
//        Ubicacion actual = buscarUbicacionPorId(idUbicacion);
//        
//        actual.setConstruccion(Construccion.POBLADO);
//        actual.setDueño(numeroJugador);
//    }
}

    
