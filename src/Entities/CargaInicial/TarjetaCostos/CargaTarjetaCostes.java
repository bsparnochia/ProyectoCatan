/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaInicial.TarjetaCostos;

import Entities.CargaInicial.TarjetaCostos.CostoCamino;
import Entities.CargaInicial.TarjetaCostos.CostoCastillo;
import Entities.CargaInicial.TarjetaCostos.CostoPoblado;
import Entities.CargaInicial.TarjetaCostos.TarjetaDeCostes;

/**
 *
 * @author Brian
 */
public class CargaTarjetaCostes {
        /* TARJETA DE COSTOS */
    private TarjetaDeCostes tarjeta;

    public CargaTarjetaCostes() {
        this.tarjeta = new TarjetaDeCostes(new CostoCamino(), new CostoPoblado(), new CostoCastillo());
    }
    
    public TarjetaDeCostes generarTarjetaDeCostes() {
        return this.tarjeta;
    }
}
