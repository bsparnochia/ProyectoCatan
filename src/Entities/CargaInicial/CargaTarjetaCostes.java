/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaInicial;

import Entities.TarjetaCostos.CostoCamino;
import Entities.TarjetaCostos.CostoCastillo;
import Entities.TarjetaCostos.CostoPoblado;
import Entities.TarjetaCostos.TarjetaDeCostes;

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
