/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;


import Entities.CargaJuegoInicial;
import Entities.Juego;


/**
 *
 * @author Brian
 */
public class ProyectoCatan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
        try {
            new ProcessBuilder("cmd", "/c", "echo").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Si falla, el programa continúa normalmente
        }
    }
        CargaJuegoInicial cargaInicial =  new CargaJuegoInicial();
        Juego catan =cargaInicial.generarConfiguracionInicialJuego();
        //catan.faseCreacionJugadoresPrueba();
        // catanPrueba.faseColocacion();
    }
        
}

//        catan.faseCreacionJugadores();
//        catan.faseEleccionOrdenJugadores();
//        catan.faseColocacion();
//        catan.jugar();
//        catan.anunciarGanador();