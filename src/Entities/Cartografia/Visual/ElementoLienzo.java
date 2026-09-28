/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Visual;

import Enumerados.Zona;

/**
 *
 * @author Brian
 */
public class ElementoLienzo {
    private int id;
    private Zona tipoZona;
    private String simbolo;
    

    public ElementoLienzo( int id, Zona tipoZona, String simbolo) {
        this.id = id;
        this.tipoZona = tipoZona;
        this.simbolo = simbolo;
    }

    public int getId() {
        return id;
    }

    public Zona getTipoZona() {
        return tipoZona;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
