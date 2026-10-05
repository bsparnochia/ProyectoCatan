/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Cartografia.Cartografo;
import Entities.Cartografia.Visual.Coordenada;
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
    private List<RegistroJugadas> registro;

    public FaseColocacionInicial(Cartografo mapa, List<Jugador> listaJugadores, List<RegistroJugadas> listadoRegistro) {
        this.mapa = mapa;
        this.listaJugadores = listaJugadores;
        this.registro = listadoRegistro; 
    }

    public List<RegistroJugadas> realizarColocacion() {
        /*Se realiza la primera ronda de colocacion de fichas en el tablero*/
        System.out.println("--Primera Ronda de Colocacion--/n/n");
        this.realizarRondaDeColocacionDirecta();

        /*Se realiza la segunda ronda de colocacion de fichas en el tablero con
        con el listado de jugadores invertido segun las reglas del Catan
         */
        System.out.println("--Segunda Ronda de Colocacion--/n/n");
        this.realizarRondaDeColocacionInversa();
        
        return this.registro;
    }

    private void realizarRondaDeColocacionDirecta() {
        System.out.println("Comienzo primera ronda de colocacion");
        for (int i = 0; i < this.listaJugadores.size(); i++) {
            this.procesoDeColacion(i);
        }
        System.out.println("fin primera ronda de colocacion");
    }

    private void realizarRondaDeColocacionInversa() {
        System.out.println("Comienzo segunda ronda de colocacion");
        int posicionInicial = this.listaJugadores.size() - 1;
        for (int i = posicionInicial; i >= 0; i--) {
            this.procesoDeColacion(i);
        }
        System.out.println("fin segunda ronda de colocacion");
    }

    private void procesoDeColacion(int indice) {
        Jugador jugadorActual = this.listaJugadores.get(indice);
        System.out.println("turno de: " + jugadorActual.getNombre());
        this.mapa.mostrarMapa();
        this.elegirUbicacionJugador(jugadorActual);
        this.mapa.mostrarMapa();
        this.elegirCaminoJugador(jugadorActual);
    }

    private void elegirUbicacionJugador(Jugador jugadorActual) {
        Coordenada coordenada = leerUbicacion();

        RegistroJugadas registroActual = this.registro.stream()
                .filter(r -> r.getNumeroJugador()== jugadorActual.getNumeroJugador())
                .findFirst()
                .orElseThrow(()-> 
                        new IllegalStateException("no existe el registro de jugador: "+jugadorActual.getNombre())
                );

        registroActual.agregarUbicacionConquistada(this.mapa.ocuparUbicacion(coordenada,jugadorActual.getNumeroJugador(),jugadorActual.getColor()));
        jugadorActual.levantarRecursosLoseta(mapa.getRecursoXCoordenada(coordenada));
    }

    /**
     * Lee las coordenadas de ubicacion seleccionadas por usuario y se asegura que sean correctas
     * @param jugadorActual
     * @return devuelve las coordenadas de una ubicacion valida del mapa
     */
    private Coordenada leerUbicacion() {
        boolean ubicacionCorrecta = false;
        Scanner sc = new Scanner(System.in);
        Coordenada buscada = null;

        System.out.println("-----CONSTRUCCION POBLADO INICIAL-----");
        while (!ubicacionCorrecta) {
            System.out.println("elija fila: ");
            int fila = sc.nextInt();
            fila--;
            System.out.println("elija columna: ");
            int columna = sc.nextInt();
            columna--;

            if (this.mapa.esUbicacionValida(fila, columna)) {
                System.out.println("ubicacion conquistada!!! ");
                ubicacionCorrecta = true;
                buscada = new Coordenada(fila, columna);
            } else {
                System.out.println("");
                System.out.println("ERROR! ubicacion incorrecta, ingrese nuevamente:");
                System.out.println("");
                this.mapa.mostrarMapa();
            }
        }
        return buscada;
    }
    
    private void elegirCaminoJugador(Jugador jugadorActual){
        Coordenada coordenada = leerCamino();

        RegistroJugadas registroActual = this.registro.stream()
                .filter(r -> r.getNumeroJugador()== jugadorActual.getNumeroJugador())
                .findFirst()
                .orElseThrow(()-> 
                        new IllegalStateException("no existe el registro de jugador: "+jugadorActual.getNombre())
                );

        registroActual.agregarCaminoConstruido(this.mapa.ocuparCamino(coordenada,jugadorActual.getNumeroJugador(),jugadorActual.getColor()));
    }

    private Coordenada leerCamino() {
        boolean caminoCorrecto = false;
        Scanner sc = new Scanner(System.in);
        Coordenada buscada = null;

        System.out.println("-----CONSTRUCCION CAMINO INICIAL-----");
        while (!caminoCorrecto) {
            System.out.println("elija fila: ");
            int fila = sc.nextInt();
            fila--;
            System.out.println("elija columna: ");
            int columna = sc.nextInt();
            columna--;

            if (this.mapa.esCaminoValido(fila, columna)) {
                System.out.println("Camino pavimentado y construidooo!!! ");
                caminoCorrecto = true;
                buscada = new Coordenada(fila, columna);
            } else {
                System.out.println("");
                System.out.println("ERROR! CAMINO incorrecto, ingrese nuevamente:");
                System.out.println("");
                this.mapa.mostrarMapa();
            }
        }
        return buscada;
    }

}
