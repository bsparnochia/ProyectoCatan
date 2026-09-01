/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.Recurso;
import java.util.List;

/**
 *
 * @author Brian
 * Las Lozetas son los hexagonos del mapa de Catan
 * cada una posee: 
 * -6 (seis) ubicaciones donde colocar poblado/castillo
 * -Un numero asignado del mapa
 * -Un recurso especifico
 * -Un ID unico
 */
public class Loseta {
    private static final int UBICACIONES_TOTALES_LOZETA = 6;
    private int numeroLoseta;
    private int id;//identifica el numero de loseta en el juego
    private Recurso recurso;
    private List<Coordenada> ubicacionesLoseta; 

    public Loseta(int numeroLoseta, int id, Recurso recurso, List<Coordenada> ubicacionesLoseta) {
        this.numeroLoseta = numeroLoseta;
        this.id = id;
        this.recurso = recurso;
        this.ubicacionesLoseta = ubicacionesLoseta;
    }
    
    public boolean contieneCoordenada(Coordenada buscada){
        return this.ubicacionesLoseta.contains(buscada);
    }

    public int getNumeroLoseta() {
        return numeroLoseta;
    }

    public int getId() {
        return id;
    }

    public Recurso getRecurso() {
        return recurso;
    }
    
    
    
}
