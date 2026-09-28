/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Grafo;

import Entities.Cartografia.Grafo.Ubicacion;

/**
 *
 * @author Brian
 */
public class Camino {
    private boolean ocupado;
    private int jugadorDueño;
    private Ubicacion Origen;
    private Ubicacion Destino;
    private int idCamino;

    public Camino(int idCamino, Ubicacion origen, Ubicacion destino) {
        this.idCamino = idCamino;
        this.ocupado = false;
        this.jugadorDueño = 0;// no esta ocupado por nadie
        this.Origen = origen;
        this.Destino = destino;
    }
    
    public boolean estaOcupado(){
        return this.ocupado;
    }

    public int getJugadorDueño() {
        return jugadorDueño;
    }

    public Ubicacion getOrigen() {
        return Origen;
    }

    public Ubicacion getDestino() {
        return Destino;
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

    @Override
    public String toString() {
        return "Camino{" + "ocupado=" + ocupado + ", jugadorDue\u00f1o=" + jugadorDueño + ", Origen=" + Origen + ", Destino=" + Destino + ", idCamino=" + idCamino + '}';
    }
    
    
    
    
}
