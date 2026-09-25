/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.TarjetaCostos;

/**
 *
 * @author Brian
 */
public class CostoCamino {
    
    private static final int COSTO_MADERA = 1;
    private static final int COSTO_ARCILLA = 1;
    
    private int cantidadMadera;
    private int cantidadArcilla;
    
    public CostoCamino() {
        this.cantidadMadera = COSTO_MADERA;
        this.cantidadArcilla = COSTO_ARCILLA;
    }

    public CostoCamino(int cantidadMadera, int cantidadArcilla) {
        this.cantidadMadera = cantidadMadera;
        this.cantidadArcilla = cantidadArcilla;
    }
    
    public int getCantidadMadera() {
        return cantidadMadera;
    }

    public int getCantidadArcilla() {
        return cantidadArcilla;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CostoCamino{");
        sb.append("cantidadMadera=").append(cantidadMadera);
        sb.append(", cantidadArcilla=").append(cantidadArcilla);
        sb.append('}');
        return sb.toString();
    }
    
    
}
