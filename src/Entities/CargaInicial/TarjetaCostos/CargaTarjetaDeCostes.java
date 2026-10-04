/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaInicial.TarjetaCostos;

/**
 *
 * @author Brian
 */
public class CargaTarjetaDeCostes {
        /* TARJETA DE COSTOS */
    private TarjetaDeCostes tarjeta;

    public CargaTarjetaDeCostes() {
        this.tarjeta = new TarjetaDeCostes(new CostoCamino(), new CostoPoblado(), new CostoCastillo());
    }
    
    public TarjetaDeCostes generarTarjetaDeCostes() {
        return this.tarjeta;
    }
}
