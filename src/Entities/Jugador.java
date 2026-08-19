/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Brian
 */
public class Jugador {
    private int puntaje;
    private Recursos recursosJugador;
    private int cantidadCaballeros;
    //private int cantidadCartaEspecial;//queda ver como se implemanta esto mas adelante
    private int cantidadCasas;
    private int cantidadCastillos;
    private int cantidadCaminosContruidos;

    public Jugador(Recursos recursosIniciales, int cantidadCasas, int cantidadCaminosContruidos) {
        this.recursosJugador = recursosIniciales;
        this.cantidadCasas = cantidadCasas;
        this.cantidadCastillos = 0;
        this.cantidadCaminosContruidos = cantidadCaminosContruidos;
        this.puntaje = 0;
        this.cantidadCaballeros = 0;
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

    public Recursos getRecursosJugador() {
        return recursosJugador;
    }

    public void setRecursosJugador(Recursos recursosJugador) {
        this.recursosJugador = recursosJugador;
    }

    public int getCantidadCaballeros() {
        return cantidadCaballeros;
    }

    public void setCantidadCaballeros(int cantidadCaballeros) {
        this.cantidadCaballeros = cantidadCaballeros;
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

    public int getCantidadCaminosContruidos() {
        return cantidadCaminosContruidos;
    }

    public void setCantidadCaminosContruidos(int cantidadCaminosContruidos) {
        this.cantidadCaminosContruidos = cantidadCaminosContruidos;
    }
}
