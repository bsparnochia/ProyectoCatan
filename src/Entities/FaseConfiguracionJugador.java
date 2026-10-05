/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Jugador.Jugador;
import java.util.List;

/**
 *
 * @author Brian
 */
public class FaseConfiguracionJugador {

    private List<Jugador> listaJugadores;
    
    public FaseConfiguracionJugador(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public void ordenarJugadores() {
        System.out.println("--PROCESO DE ORDENAR PENDIENTE DE IMPLEMENTAR!--");
    }

    public void mostrarJugadoresOrdenados() {
        System.out.println("-->> LISTA DE JUGADORES:");
        for(Jugador j: listaJugadores){
            System.out.println(j.toString());
            System.out.println("");
        }
    }
    
    
}
