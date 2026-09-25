/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaInicial;

import Entities.Cartografia.Loseta;
import Entities.Cartografia.Losetario;
import Entities.Cartografia.Visual.Mapa;
import java.util.List;

/**
 *
 * @author Brian
 */
public class CargaInicial {
    private CargaMapa cargaLienzo;
    private CargaLosetas cargaLosetas;
    private DistribuidorNumeros distribuidor;

    public CargaInicial() {
        this.cargaLienzo = new CargaMapa();
        this.cargaLosetas = new CargaLosetas();
        this.distribuidor = new DistribuidorNumeros();
    }
    
    public Mapa configurarMapa(){
        Mapa lienzo = this.cargaLienzo.generarPreLienzo();
        List<Loseta> listaLosetas = this.cargaLosetas.generarLosetas();
        Losetario losetario = new Losetario(listaLosetas);
        //this.cargaLosetas.showLosetasGeneradas();
        int idLadron = losetario.getIdLadron();
        //System.out.println("Loseta del ladron: "+idLadron);
        List<NumeracionCatan> ordenNumerosLosetario =this.distribuidor.distribuirNumerosEnLosetas(idLadron);
        lienzo.configurarNumeros(ordenNumerosLosetario);
        losetario.configurarNumeros(ordenNumerosLosetario);
        //losetario.showLosetasGeneradas();
        lienzo.showMapa();
        lienzo.showMapaPintado();

//        lienzo.showIDlosetas();

        
        return lienzo; 
    }
    
}
