/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Brian
 */
public class TarjetaDeCostes {
    private CostoCamino costoCamino;
    private CostoPoblado costoPoblado;
    private CostoCastillo costoCastillo;
    //private CostoCartaEspecial costoCartaEspecial; proximamente!!!

    public TarjetaDeCostes(CostoCamino costoCamino, CostoPoblado costoPoblado, CostoCastillo costoCastillo/*, CostoCartaEspecial costoCartaEspecial*/) {
        this.costoCamino = costoCamino;
        this.costoPoblado = costoPoblado;
        this.costoCastillo = costoCastillo;
    }

    public CostoCamino getCostoCamino() {
        return costoCamino;
    }

    public CostoPoblado getCostoPoblado() {
        return costoPoblado;
    }

    public CostoCastillo getCostoCastillo() {
        return costoCastillo;
    }
    
    
}
