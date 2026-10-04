/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaInicial.CargaLienzo;


import Entities.Cartografia.Losetario;
import Entities.Cartografia.Visual.Lienzo;
import java.util.List;

/**
 *
 * @author Brian
 */
public class CargaInicialMapa {
    private CargaLienzo cargaLienzo;
    private CargaLosetas cargaLosetas;
    private DistribuidorNumeros distribuidor;
    private Lienzo lienzo;
    private Losetario losetario;

    public CargaInicialMapa() {
        this.cargaLienzo = new CargaLienzo();
        this.cargaLosetas = new CargaLosetas();
        this.distribuidor = new DistribuidorNumeros();
        this.configurarMapa();
    }
    
    public final void configurarMapa(){
        this.lienzo = this.cargaLienzo.generarPreLienzo();

        this.losetario = new Losetario(this.cargaLosetas.generarLosetas());
        int idLadron = losetario.getIdLadron();
        //System.out.println("Loseta del ladron: "+idLadron);
        List<NumeracionCatan> ordenNumerosLosetario =this.distribuidor.distribuirNumerosEnLosetas(idLadron);
        lienzo.configurarNumeros(ordenNumerosLosetario);
        losetario.configurarNumeros(ordenNumerosLosetario);        
    }
    
    public Losetario crearLosetario(){
        return this.losetario;
    }
    
    public Lienzo crearLienzo(){
        return this.lienzo;
    }
    
}
