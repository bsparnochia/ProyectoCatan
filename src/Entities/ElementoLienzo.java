/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.Superficie;
import Enumerados.TipoZona;

/**
 *
 * @author Brian
 */
class ElementoLienzo {
    private Superficie tipoSuperficie;
    private int id;
    private TipoZona tipoZona;

    public ElementoLienzo(Superficie tipoSuperficie, int id, TipoZona tipoZona) {
        this.tipoSuperficie = tipoSuperficie;
        this.id = id;
        this.tipoZona = tipoZona;
    }

    public Superficie getTipoSuperficie() {
        return tipoSuperficie;
    }

    public int getId() {
        return id;
    }

    public TipoZona getTipoZona() {
        return tipoZona;
    }
    
    
}
