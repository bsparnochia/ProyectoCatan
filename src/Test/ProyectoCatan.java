/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;


import Entities.Juego;
import Entities.PreparadorDeJuegos;
import Entities.Ubicacion;

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
      System.out.println("HOLA CATAN 1.0!");

      

    
        PreparadorDeJuegos master = new PreparadorDeJuegos();
        master.generarUbicaciones();
//        Juego catan = new Juego(master.generarMapa(),master.generarTarjetaDeCostes());
        
//        catan.faseCreacionJugadores();
//        catan.faseEleccionOrdenJugadores();
//        catan.faseColocacion();
//        catan.jugar();
//        catan.anunciarGanador();
    }
}
    
