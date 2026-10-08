/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Brian
 */
public class Mensajes {

    public void mostrarMenuAccionesJugador() {
        System.out.println("**** ACCIONES ******");
        System.out.println("1-TRADEAR RECURSOS");
        System.out.println("2-CONSTRUIR");
        System.out.println("3-COMPRAR RECURSOS BANCO");
        System.out.println("4-USAR CARTA ESPECIAL");
        System.out.println("5-TERMINAR TURNO");
        System.out.println("");
        System.out.println("ingrese una opcion: ");
    }

    public void anunciarGanador(String nombreJugador) {
        System.out.println("------------------------------------------------------");
        System.out.println("¡GANADOR!  ->  " + nombreJugador);
        System.out.println("------------------------------------------------------");
    }

    public void enunciarTurnoDeJugador(String nombre){
        System.out.println("turno de: " + nombre);
    }

    void mostrarMenuInicioTurnoJugador() {
        System.out.println("**** ACCIONES ******");
        System.out.println("1-LANZAR DADOS!");
        System.out.println("2-USAR CARTA ESPECIAL");
        System.out.println("");
        System.out.println("ingrese una opcion: ");
    }
}

