/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaInicial.TarjetaCostos;

/**
 *
 * @author Brian
 */
public class CostoPoblado {
    private static final int COSTO_MADERA = 1;
    private static final int COSTO_ARCILLA = 1;
    private static final int COSTO_OVEJA = 1;
    private static final int COSTO_TRIGO = 1;

    private int cantidadMadera;
    private int cantidadArcilla;
    private int cantidadOveja;
    private int cantidadTrigo;
    
    
    // seguir con clases de costos mañana! segun el ejemplo de costo camino que ya esta creada :P

    public CostoPoblado() {
        this.cantidadMadera = COSTO_MADERA;
        this.cantidadArcilla = COSTO_ARCILLA;
        this.cantidadOveja = COSTO_OVEJA;
        this.cantidadTrigo = COSTO_TRIGO;
    }

    public CostoPoblado(int cantidadMadera, int cantidadArcilla, int cantidadOveja, int cantidadTrigo) {
        this.cantidadMadera = cantidadMadera;
        this.cantidadArcilla = cantidadArcilla;
        this.cantidadOveja = cantidadOveja;
        this.cantidadTrigo = cantidadTrigo;
    }

    public int getCantidadMadera() {
        return cantidadMadera;
    }

    public int getCantidadArcilla() {
        return cantidadArcilla;
    }

    public int getCantidadOveja() {
        return cantidadOveja;
    }

    public int getCantidadTrigo() {
        return cantidadTrigo;
    }

    @Override
    public String toString() {
        return "CostoPoblado{" + "cantidadMadera=" + cantidadMadera + ", cantidadArcilla=" + cantidadArcilla + ", cantidadOveja=" + cantidadOveja + ", cantidadTrigo=" + cantidadTrigo + '}';
    }
    
    
}
