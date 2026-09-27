/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Grafo;

/**
 *
 * @author Brian
 */
public class Arista {
    private Vertice origen;
    private Vertice destino;
    private int id;
    /*por ahora no esta definido el uso de ID en las aristas*/
    private static final int NO_DEFINIDO=-1;
    
    public Arista(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
        this.id = NO_DEFINIDO;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Arista{" + "origen=" + origen + ", destino=" + destino + ", id=" + id + '}';
    }
    
    
    
    
}
