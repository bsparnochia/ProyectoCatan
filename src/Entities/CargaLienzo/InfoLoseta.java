/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaLienzo;

/**
 *
 * @author Brian
 */
public class InfoLoseta {
    private int id;
    private int losetaAdyacenteInterior;


    public InfoLoseta(int id, int losetaAdyacenteInterior) {
        this.id = id;
        this.losetaAdyacenteInterior = losetaAdyacenteInterior;
    }

    public int getId() {
        return id;
    }
    
    public int getLosetaAdyacenteInterior() {
        return this.losetaAdyacenteInterior; 
    }
    
    
}
