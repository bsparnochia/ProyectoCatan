/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Fases;

import Entities.Cartografia.Cartografo;
import Entities.EstadosPartida.HistorialDeProgresos;
import Entities.EstadosPartida.ProgresoJugador;
import Entities.Jugador.Jugador;
import java.util.List;

/**
 *
 * @author Brian
 */
public class FaseChequeoEstadoJuego {

    private List<Jugador> jugadores;
    private HistorialDeProgresos registroProgreso;
    private static final int PUNTAJE_GANADOR = 10;

    public FaseChequeoEstadoJuego(Cartografo mapa, List<Jugador> listaJugadores, HistorialDeProgresos registroProgreso) {
        this.jugadores = listaJugadores;
        this.registroProgreso = registroProgreso;
    }

    public boolean getEstadoPartida(Jugador jugadorActual) {
        boolean hayGanador = false;

        ProgresoJugador registroJugador = this.registroProgreso.getProgresoSegunNumeroJugador(jugadorActual.getNumeroJugador());
        if (esPuntajeGanador(registroJugador.consultarPuntaje())) {
            hayGanador = true;
        }

        return hayGanador;
    }

    private boolean esPuntajeGanador(int puntaje) {
        return puntaje >= PUNTAJE_GANADOR;
    }

}
