/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Brian
 */
public class Camino {
    private boolean ocupado;
    private int jugadorDueño;
    private int idOrigen;
    private int idDestino;
    private int idCamino;

    public Camino(int idCamino, int idOrigen, int idDestino) {
        this.idCamino = idCamino;
        this.ocupado = false;
        this.jugadorDueño = 0;// no esta ocupado por nadie
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
    }
    
    public boolean estaOcupado(){
        return this.ocupado;
    }

    public int getJugadorDueño() {
        return jugadorDueño;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public int getIdCamino() {
        return idCamino;
    }

    public void ocuparCamino() {
        this.ocupado = true;
    }

    public void setJugadorDueño(int jugadorDueño) {
        this.jugadorDueño = jugadorDueño;
    }
    
    
    
    
}
