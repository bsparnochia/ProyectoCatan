/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.Recurso;

/**
 *
 * @author Brian
 */
public class ManoDeCartas {
    private static final int MANO_VACIA = 0;
    private int arcilla;
    private int trigo;
    private int piedra;
    private int madera;
    private int oveja;

    public ManoDeCartas(){
        this.arcilla = MANO_VACIA;
        this.trigo = MANO_VACIA;
        this.piedra = MANO_VACIA;
        this.madera = MANO_VACIA;
        this.oveja = MANO_VACIA;
    }
   
    
    
    public void agregarRecurso( Recurso r, int cantidad){
        switch(r){
            case Recurso.ARCILLA: 
        this.arcilla += cantidad;
        break;
            case Recurso.MADERA:
        this.madera += cantidad;
        break;
            case Recurso.OVEJA:
        this.oveja += cantidad;
        break;
            case Recurso.TRIGO:
        this.trigo += cantidad;
        break;
            case Recurso.PIEDRA:
        this.piedra += cantidad;
        break;
        }
    }
    
    /**
     * Posible tema para consultar en la IA para aprender a hacer mas codigo-> si conviene hacer un bool como bandera si quiero agregar o utilizar recursos
     * ya que se ve que es la misma estructura, nomas que en vez de sumar, resta.
     * @param r
     * @param cantidad 
     */
   public void consumirRecurso( Recurso r, int cantidad){
        switch(r){
            case Recurso.ARCILLA: 
        this.arcilla -= cantidad;
        break;
            case Recurso.MADERA:
        this.madera -= cantidad;
        break;
            case Recurso.OVEJA:
        this.oveja -= cantidad;
        break;
            case Recurso.TRIGO:
        this.trigo -= cantidad;
        break;
            case Recurso.PIEDRA:
        this.piedra -= cantidad;
        break;
        }
   }

    public int getArcilla() {
        return arcilla;
    }

    public int getTrigo() {
        return trigo;
    }

    public int getPiedra() {
        return piedra;
    }

    public int getMadera() {
        return madera;
    }

    public int getOveja() {
        return oveja;
    }
    
}
