/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Brian
 */
public class CostoCastillo {
    private static final int COSTO_PIEDRA = 3;
    private static final int COSTO_TRIGO = 2;
    
    private int cantidadPiedra;
    private int cantidadTrigo;

    public CostoCastillo() {
        this.cantidadPiedra = COSTO_PIEDRA;
        this.cantidadTrigo = COSTO_TRIGO;
    }

    public CostoCastillo(int cantidadPiedra, int cantidadTrigo) {
        this.cantidadPiedra = cantidadPiedra;
        this.cantidadTrigo = cantidadTrigo;
    }

    public int getCantidadPiedra() {
        return cantidadPiedra;
    }

    public int getCantidadTrigo() {
        return cantidadTrigo;
    }

    @Override
    public String toString() {
        return "CostoCastillo{" + "cantidadPiedra=" + cantidadPiedra + ", cantidadTrigo=" + cantidadTrigo + '}';
    }
    
    
}
