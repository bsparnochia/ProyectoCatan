/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia;

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
    private static final String NUMERO_NO_DEFINIDO = "0";
    private String numeroLoseta;
    private int id;//identifica el numero de loseta en el juego
    private Recurso recurso;
    private List<Integer> ubicacionesLoseta; 

    public Loseta( int id, Recurso recurso, List<Integer> ubicacionesLoseta) {
        this.numeroLoseta = NUMERO_NO_DEFINIDO;
        this.id = id;
        this.recurso = recurso;
        this.ubicacionesLoseta = ubicacionesLoseta;
    }

    public void setNumeroLoseta(String numeroLoseta) {
        this.numeroLoseta = numeroLoseta;
    }
    
    
    
    public boolean contieneCoordenada(int buscada){
        return this.ubicacionesLoseta.contains(buscada);
    }

    public String getNumeroLoseta() {
        return numeroLoseta;
    }

    public int getId() {
        return id;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    @Override
    public String toString() {
        return "Loseta{" + "numeroLoseta=" + numeroLoseta + ", id=" + id + ", recurso=" + recurso + ", ubicacionesLoseta=" + ubicacionesLoseta + '}';
    }
    
    
    
}
