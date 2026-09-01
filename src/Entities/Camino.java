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
    private Coordenada idOrigen;
    private Coordenada idDestino;
    private int idCamino;

    public Camino() {
        //completarthis.idCamino =
        this.ocupado = false;
        this.jugadorDueño = 0;// no esta ocupado por nadie
    }
    
    public boolean estaOcupado(){
        return this.ocupado;
    }

    public int getJugadorDueño() {
        return jugadorDueño;
    }

    public void ocuparCamino() {
        this.ocupado = true;
    }

    public void setJugadorDueño(int jugadorDueño) {
        this.jugadorDueño = jugadorDueño;
    }
    
    
    
    
}
