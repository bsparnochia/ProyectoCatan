/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Cartografia.Cartografo;
import Entities.Jugador.Jugador;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class FaseColocacionInicial {

    private Cartografo mapa;
    private List<Jugador> listaJugadores;

    public FaseColocacionInicial(Cartografo mapa, List<Jugador> listaJugadores) {
        this.mapa = mapa;
        this.listaJugadores = listaJugadores;
    }

    public void realizarColocacion() {
        /*Se realiza la primera ronda de colocacion de fichas en el tablero*/
        System.out.println("--Primera Ronda de Colocacion--/n/n");
        this.realizarRondaDeColocacionDirecta();

        /*Se realiza la segunda ronda de colocacion de fichas en el tablero con
        con el listado de jugadores invertido segun las reglas del Catan
         */
        System.out.println("--Segunda Ronda de Colocacion--/n/n");
        this.realizarRondaDeColocacionInversa();
    }

    private void realizarRondaDeColocacionDirecta() {
        for (int i = 0; i < this.listaJugadores.size(); i++) {
            this.mapa.mostrarMapa();
            this.elegirUbicacionJugador(this.listaJugadores.get(i));
        }
    }

    private void realizarRondaDeColocacionInversa() {
        int posicionInicial = this.listaJugadores.size() - 1;
        for (int i = posicionInicial; i >= 0; i--) {
            this.mapa.mostrarMapa();
            this.elegirUbicacionJugador(this.listaJugadores.get(i));
        }
    }

    private void elegirUbicacionJugador(Jugador jugadorActual) {
        boolean ubicacionIncorrecta = true;
        while (ubicacionIncorrecta) {
            ubicacionIncorrecta = leerUbicacion(jugadorActual);
        }
    }

    private boolean leerUbicacion(Jugador jugadorActual) {
        boolean ubicacionCorrecta = false;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-----CONSTRUCCION POBLADO INICIAL-----");
        System.out.println("elija fila: ");
        int fila = sc.nextInt();
        System.out.println("elija columna: ");
        int columna = sc.nextInt();

        if (!this.mapa.ubicacionEstaOcupada(fila, columna)) {
            this.mapa.ocuparUbicacion(jugadorActual.getNumeroJugador(), fila, columna);
        }

        return ubicacionCorrecta;
    }
}
