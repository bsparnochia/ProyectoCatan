/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Jugador;

import Enumerados.ColorJugador;
import Enumerados.Recurso;

/**
 *
 * @author Brian
 */
public class Jugador {
    private int numeroJugador;
    private String nombre;
    private ColorJugador color;
    private int puntaje;
    private ManoDeCartas mano;
    private int cantidadCasas;
    private int cantidadCastillos;
    //private int cantidadCaballeros;//queda ver como se implemanta esto mas adelante
    //private int cantidadCartaEspecial;//queda ver como se implemanta esto mas adelante

    public Jugador(int numeroJugador, String nombre, ManoDeCartas recursosIniciales, int cantidadCasas, ColorJugador color) {
        this.numeroJugador = numeroJugador;
        this.nombre = nombre;
        this.color = color;
        this.puntaje = 0;
        this.mano = recursosIniciales;
        this.cantidadCasas = cantidadCasas;
        this.cantidadCastillos = 0;
        //this.cantidadCaballeros = 0;
        //this.cantidadCartaEspecial = 0;
    }

    public Jugador(int numeroJugador, String nombre, ColorJugador color) {
        this.numeroJugador = numeroJugador;
        this.nombre = nombre;
        this.color = color;
        this.puntaje = 0;
        this.mano = new ManoDeCartas();
        this.cantidadCasas = 0;
        this.cantidadCastillos = 0;
        //this.cantidadCaballeros = 0;
        //this.cantidadCartaEspecial = 0;
    }
    
    public int tirarDados(){
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

    public ColorJugador getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
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
