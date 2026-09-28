/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaLienzo;

/**
 *
 * @author Brian
 */
public class NumeracionCatan {

    private int id;
    String numeroLoseta;

    public NumeracionCatan(int id, String numeroLoseta) {
        this.id = id;
        this.numeroLoseta = numeroLoseta;
    }

    public int getId() {
        return id;
    }

    public String getNumeroLoseta() {
        return numeroLoseta;
    }

    @Override
    public String toString() {
        return "NumeracionCatan{" + "id=" + id + ", numeroLoseta=" + numeroLoseta + '}';
    }
    
    
    
}
