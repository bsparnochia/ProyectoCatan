/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.EstadosPartida;

import Entities.Jugador.Jugador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class HistorialDeProgresos {

    private List<ProgresoJugador> registroDeJugadores;

    public HistorialDeProgresos(List<Jugador> listaJugadores) {
        this.registroDeJugadores = new ArrayList();
        for (Jugador j : listaJugadores) {
            registroDeJugadores.add(new ProgresoJugador(j.getNumeroJugador()));
        }
    }

    public ProgresoJugador getProgresoSegunNumeroJugador(int numeroJugador) {
        //las posiciones de registro coinciden con las posiciones en lista de los jugadores
        return this.registroDeJugadores.get(numeroJugador-1);
    }
    
    public void mostrarRegistro() {
        System.out.println("CHECK REGISTRO JUGADAS");
        for(ProgresoJugador r: this.registroDeJugadores){
            System.out.println("");
            System.out.println(r.toString());
            System.out.println("");
        }
    }
}
