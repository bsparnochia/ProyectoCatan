/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Brian
 */
public class BitacoraConstrucciones {
    private static final int NO_CONSTRUIDO = 0;
    private int pobladosConstruidos;
    private int castillosConstruidos;

    public BitacoraConstrucciones() {
        this.pobladosConstruidos = NO_CONSTRUIDO;
        this.castillosConstruidos = NO_CONSTRUIDO;
    }

    public int getPobladosConstruidos() {
        return pobladosConstruidos;
    }

    public void agregarPobladosConstruidos() {
        this.pobladosConstruidos++;
    }

    public int getCastillosConstruidos() {
        return castillosConstruidos;
    }

    public void agregarCastillosConstruidos() {
        this.castillosConstruidos++;
    }
    
    
}
