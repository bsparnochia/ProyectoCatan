/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Brian
 */
public class Recursos {
    private int arcilla;
    private int trigo;
    private int piedra;
    private int madera;
    private int oveja;

    public Recursos(int arcilla, int trigo, int piedra, int madera, int oveja) {
        this.arcilla = arcilla;
        this.trigo = trigo;
        this.piedra = piedra;
        this.madera = madera;
        this.oveja = oveja;
    }

    public int getArcilla() {
        return arcilla;
    }

    public void setArcilla(int arcilla) {
        this.arcilla = arcilla;
    }

    public int getTrigo() {
        return trigo;
    }

    public void setTrigo(int trigo) {
        this.trigo = trigo;
    }

    public int getPiedra() {
        return piedra;
    }

    public void setPiedra(int piedra) {
        this.piedra = piedra;
    }

    public int getMadera() {
        return madera;
    }

    public void setMadera(int madera) {
        this.madera = madera;
    }

    public int getOveja() {
        return oveja;
    }

    public void setOveja(int oveja) {
        this.oveja = oveja;
    }
    
    
}
