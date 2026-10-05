/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Jugador;

import Enumerados.Color;
import Enumerados.Recurso;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Brian
 */
public class Jugador {
    private int numeroJugador;
    private String nombre;
    private Color color;
    private int puntaje;
    private ManoDeCartas mano;
    private int cantidadCasas;
    private int cantidadCastillos;
    //private int cantidadCaballeros;//queda ver como se implemanta esto mas adelante
    //private int cantidadCartaEspecial;//queda ver como se implemanta esto mas adelante


    public Jugador(int numeroJugador, String nombre, Color color) {
        this.numeroJugador = numeroJugador;
        this.nombre = nombre;
        this.color = color;
        this.puntaje = 0;
        this.mano = new ManoDeCartas();
        //this.cantidadCaballeros = 0;
        //this.cantidadCartaEspecial = 0;
    }
    
    public int tirarDados(){
        return new Random().nextInt(1, 13); 
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

    public Color getColor() {
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
        /*
    Levanta los recursos de un listado de recursos obtenidos
    */
    public void levantarRecursosLoseta( List<Recurso> lista){
        for( Recurso r: lista){
            this.mano.agregarRecurso(r);
        }
    }    
    
    @Override
    public String toString() {
        return "Jugador{" + "numeroJugador=" + numeroJugador + ", nombre=" + nombre + ", color=" + color + ", puntaje=" + puntaje + ", \nmano=" + mano + '}';
    }
    
    
    
}
