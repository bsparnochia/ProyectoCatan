/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.PaletaColores;
import Enumerados.Recurso;

/**
 *
 * @author Brian
 */
public class Jugador {
    private int puntaje;
    private int numeroJugador;
    private PaletaColores color;
    private ManoDeCartas mano;
    //private int cantidadCaballeros;//queda ver como se implemanta esto mas adelante
    //private int cantidadCartaEspecial;//queda ver como se implemanta esto mas adelante
    private int cantidadCasas;
    private int cantidadCastillos;

    public Jugador(int numeroJugador, ManoDeCartas recursosIniciales, int cantidadCasas) {
        this.mano = recursosIniciales;
        this.cantidadCasas = cantidadCasas;
        this.cantidadCastillos = 0;
        this.puntaje = 0;
        //this.cantidadCaballeros = 0;
        this.numeroJugador = numeroJugador;
        //this.cantidadCartaEspecial = 0;
    }

    Jugador(PaletaColores color, String nombre, int numeroJugador) {
        this.numeroJugador = numeroJugador;
        this.mano = null;
        this.cantidadCasas = 0;
        this.cantidadCastillos = 0;
        this.puntaje = 0;
        //this.cantidadCaballeros = 0;
        //this.cantidadCartaEspecial = 0;
    }
    
    int tirarDados(){
        return 5; //ver que formula hay para tirar dados al azar
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public ManoDeCartas getRecursosJugador() {
        return mano;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public PaletaColores getColor() {
        return color;
    }

    
    /*
    Levanta la cantidad de recursos indicada y la guarda en su mano
    */
    public void levantarRecursosLoseta( Recurso r, int cantidad){
        this.mano.agregarRecurso(r, cantidad);
    }

    public int getCantidadCasas() {
        return cantidadCasas;
    }

    public void setCantidadCasas(int cantidadCasas) {
        this.cantidadCasas = cantidadCasas;
    }

    public int getCantidadCastillos() {
        return cantidadCastillos;
    }

    public void setCantidadCastillos(int cantidadCastillos) {
        this.cantidadCastillos = cantidadCastillos;
    }
    
}
