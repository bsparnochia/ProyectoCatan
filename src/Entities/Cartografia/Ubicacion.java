/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia;

import Enumerados.Construccion;

/**
 *
 * @author Brian
 */
public class Ubicacion {
    private Construccion construccion;//tipo de construccion en la ubicacion
    private int dueño;//recibe el numero del jugador
    private int id;
    
    

    public Ubicacion(int id) {
        this.construccion = Construccion.VACIO;
        this.dueño = 0;
        this.id = id;
    }
    
    public boolean estaOcupada(){
        return this.construccion == Construccion.VACIO;
    }
    public Construccion getConstruccion() {
        return construccion;
    }

    public void setConstruccion(Construccion construccion) {
        this.construccion = construccion;
    }

    public int getDueño() {
        return dueño;
    }

    public void setDueño(int dueño) {
        this.dueño = dueño;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "construccion=" + construccion + ", due\u00f1o=" + dueño + ", id=" + id + '}';
    }
    
    
}
