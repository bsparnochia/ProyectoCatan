/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.PaletaColores;
import Interfaces.I_LogicaJuego;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class Juego implements I_LogicaJuego{
    
     private List <Jugador> listaJugadores;
     private Jugador ganador;
     private Scanner sc;
     private final int NO_DEFINIDO = 0;
     
    public Juego(){
       listaJugadores = new ArrayList();
       sc = new Scanner(System.in);
       this.ganador = null;
    }

    @Override
    /**
     * En esta fase se crean los jugadores con nombre, color elegido de las estructuras
     * y el numero de jugador
     * NOTA!: el numero de jugador es PROVISORIO, solo sirve para dar un orden inicial
     * para resolver la siguiente fase: faseEleccionOrdenJugadores()
     */
    public void faseCreacionJugadores() {
        System.out.println("ingrese cantidad de jugadores: ");
        int cantidadJugadores = sc.nextInt();
        for (int i=1; i<cantidadJugadores; i++){
            System.out.println("ingrese nombre jugador");
            String nombre= sc.nextLine();
            System.out.println("Elija color disponible: ");
            mostrarColoresDisponibles();//implementar
            PaletaColores color = elegirColorJugador();//implementar
            Jugador nuevoJugador = new Jugador(color,nombre,i);//creamos jugador
            this.listaJugadores.add(nuevoJugador);
        }
    }
    
    @Override
    public void faseEleccionOrdenJugadores() {
        int primerJugador = NO_DEFINIDO;
        for (Jugador jugador : this.listaJugadores){
            System.out.println("Tirar dados! presione enter para agitar y lanzarlos con estilo");
            sc.nextLine();
            int resultado = jugador.tirarDados();
            primerJugador = evaluarTirada(resultado);
        }
        this.listaJugadores = ordenarJugadores(primerJugador);
        
    }

    @Override
    public void faseColocacion() {
        for (Jugador jugadorActual : this.listaJugadores){
            //magia a implementar
        }
        // para hacer la colocacion inversa de casas y caminos, invierto la lista
        List<Jugador> listaInvertida = invertirLista();
        for (Jugador jugadorActual : listaInvertida){
            //magia a implementar
        }
    }

    @Override
    public void jugar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void anunciarGanador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void mostrarColoresDisponibles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private PaletaColores elegirColorJugador(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private List<Jugador> ordenarJugadores(int primerJugador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int evaluarTirada(int resultado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private List<Jugador> invertirLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
