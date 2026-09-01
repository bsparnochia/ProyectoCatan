/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.Construccion;
import Enumerados.Superficie;

/**
 *
 * @author Brian
 */
public class Ubicacion {
    private Superficie superficie;
    private Construccion construccion;//tipo de construccion en la ubicacion
    private int dueño;//recibe el numero del jugador
    
    

    public Ubicacion(Superficie superficie) {
        this.superficie = superficie;
        this.construccion = Construccion.VACIO;
        this.dueño = 0;
    }

    public boolean esAgua(){
        return this.superficie == Superficie.AGUA;
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
    
    
    
}
