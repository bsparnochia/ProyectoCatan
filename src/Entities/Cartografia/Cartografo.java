/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia;

import Entities.Cartografia.Grafo.Camino;
import Entities.Cartografia.Grafo.Grafo;
import Entities.Cartografia.Grafo.Ubicacion;
import Entities.Cartografia.Visual.Coordenada;
import Entities.Cartografia.Visual.Lienzo;
import Entities.Jugador.Jugador;
import Enumerados.Color;
import Enumerados.Construccion;
import Enumerados.Recurso;
import Enumerados.Zona;
import java.util.List;

/**
 *
 * @author Brian
 */
public class Cartografo {

    private Grafo mapa;
    private Losetario losetario;
    private Lienzo lienzo;

    public Cartografo(Grafo grafo, Lienzo lienzo, Losetario losetario) {
        this.mapa = grafo;
        this.losetario = losetario;
        this.lienzo = lienzo;
    }

    /**
     * Muestra el mapa pintado, donde esta el ladron y el recurso anulado en esa
     * loseta
     */
    public void mostrarMapa() {
        this.lienzo.showMapaPintado();
        System.out.println("El ladron esta en la loseta: " + this.losetario.getLosetaLadron().getNumeroLoseta());
        System.out.println("Recurso: " + this.losetario.getLosetaLadron().getRecurso());
        //this.lienzo.showMapaPintadoC();
    }

//    public Recurso getRecursoSegunTirada(int dados){
//        Recurso r= Recurso.TRIGO; //terminar, esta hecho basico para que funcione para probar codigo
//        return r;
//    }

    /**
     * Ocupa la posicion en el mapa y el jugador registra su ubicacion en su
     * anotador
     *
     * @param numeroJugador
     * @param color
     * @param c
     * @return Ubicacion
     */
    public Ubicacion ocuparUbicacion(Coordenada c, int numeroJugador, Color color) {
        int idUbicacion = this.lienzo.getIdXcoordenada(c.getFila(), c.getColumna());
        Ubicacion actual = this.mapa.getUbicacionXid(idUbicacion);

        actual.setConstruccion(Construccion.POBLADO);
        actual.setDueño(numeroJugador);

        this.lienzo.pintarPoblado(c,numeroJugador,color);
        return actual;
    }

    /**
     * verifica que la posicion este ocupada segun una fila y columna ingresada por el jugador
     *
     * @param fila
     * @param columna
     * @return devuelve false si esta libre, si esta ocupada true
     */
    public boolean ubicacionEstaOcupada(int fila, int columna) {
        return this.mapa.getUbicacionXid(this.lienzo.getIdXcoordenada(fila,columna)).estaOcupada();
    }

    /**
     * verifica que la posicion este ocupada segun la coordenada ingresada por el jugador
     * @param coordenada
     * @return 
     */
    public boolean ubicacionEstaOcupada(Coordenada coordenada) {
           return this.mapa.getUbicacionXid(this.lienzo.getIdXcoordenada(coordenada)).estaOcupada();
    }

    public boolean esUbicacionValida(int fila, int columna) {
        return (this.esCoordenadaValida(fila, columna) && this.esUbicacion(fila,columna)) && !this.ubicacionEstaOcupada(fila, columna);
    }
    
    private boolean esCoordenadaValida(int fila, int columna){
        return ((fila >= 0) && (fila < 12)) && ((columna >= 0) && (columna < 22));
    }

    private boolean esUbicacion(int fila, int columna) {
        return this.lienzo.getElementoXcoordenada(fila, columna).getTipoZona() == Zona.UBICACION;
    }

    public List<Recurso> getRecursoXCoordenada(Coordenada coordenada) {
        return this.losetario.getRecursoXid(this.lienzo.getIdXcoordenada(coordenada));
    }

    
    /** ----------------- CAMINOS (UTILIDADES)---------------- **/
    
    /**
     * Ocupa el camino del mapa con el color del jugador, su numero guardado y segun una coordenada
     * @param c
     * @param numeroJugador
     * @param color
     * @return 
     */
    public Camino ocuparCamino(Coordenada c, int numeroJugador, Color color) {
        int idCamino = this.lienzo.getIdXcoordenada(c.getFila(), c.getColumna());
        Camino actual = this.mapa.getCaminoXid(idCamino);

        actual.ocuparCamino(numeroJugador);

        this.lienzo.pintarCamino(c,color);
        return actual;    
    }
    
    private boolean esCamino(int fila, int columna) {
        return this.lienzo.getElementoXcoordenada(fila, columna).getTipoZona() == Zona.CAMINO;
    }
    
    private boolean caminoEstaOcupado(int fila, int columna) {
        return this.mapa.getCaminoXid(this.lienzo.getIdXcoordenada(fila,columna)).estaOcupado();
    }
    
    public boolean esCaminoValido(int fila, int columna) {
        return (this.esCoordenadaValida(fila, columna) && this.esCamino(fila,columna)) && !this.caminoEstaOcupado(fila, columna);
    }

}
