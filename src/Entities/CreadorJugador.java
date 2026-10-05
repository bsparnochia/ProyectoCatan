/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Jugador.Jugador;
import Enumerados.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class CreadorJugador {
    
    private List<Jugador> listaJugadores;
    private static final int NO_DEFINIDO = 0;

    public CreadorJugador() {
        this.listaJugadores = new ArrayList();
    }
    
    
    
        /**----------------- CREACION DE JUGADORES ----------------- **/
    
    //genera una lista de jugadores de prueba con 2 jugadores
    /**
     * Metodo de prueba para testear con jugadores prearmados ( en total 2 jugadores )
     * @return 
     */
    public List<Jugador> faseCreacionJugadoresPrueba(){

        this.listaJugadores.add(new Jugador(1,"Elute",Color.ROJO));
        this.listaJugadores.add(new Jugador(2,"Pelu",Color.AZUL));
        
        return listaJugadores;
    }
    
    
    /**
     * En esta fase se crean los jugadores con nombre, color elegido de las estructuras
     * y el numero de jugador
     * NOTA!: el numero de jugador es PROVISORIO, solo sirve para dar un orden inicial
     * para resolver la siguiente fase: faseEleccionOrdenJugadores()
     * @return 
     */
    public List<Jugador> faseCreacionJugadores() {

        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese cantidad de jugadores: ");
        int cantidadJugadores = sc.nextInt();
        for (int i=1; i<cantidadJugadores; i++){
            System.out.println("ingrese nombre jugador");
            String nombre= sc.nextLine();
            System.out.println("Elija color disponible: ");
            mostrarColoresDisponibles();//implementar
            Color color = elegirColorJugador();//implementar
            Jugador nuevoJugador = new Jugador(i,nombre,color);//creamos jugador
            listaJugadores.add(nuevoJugador);
        }
        
        this.ordenarJugadores();
        
        return listaJugadores;
   }
    private void mostrarColoresDisponibles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Color elegirColorJugador(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    /**---------------- ORDENAMIENTO DE TURNOS DE JUGADORES ----------------**/
    
    /**
     * ordena los jugadores segun su puntaje de tirada y elegi quien arranca primero el juego
     */
    private void ordenarJugadoresXtirada() {
        int primerJugador = NO_DEFINIDO;
        Scanner sc = new Scanner(System.in);
        for (Jugador jugador : this.listaJugadores){
            System.out.println("Tirar dados! presione enter para agitar y lanzarlos con estilo");
            sc.nextLine();
            int resultado = jugador.tirarDados();
            primerJugador = evaluarTirada(resultado);
        }
        listaJugadores = ordenarJugadores(primerJugador);
        
    }
    
    /**
     * Compara el lanzamiento del jugador con el de los demas jugadores para buscar quien saco el numero mas alto
     * @param resultado
     * @return 
     */
    private int evaluarTirada(int resultado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * reordena la lista a partir del jugador con puntaje de dados mas altos en su lanzamiento inicial
     * @param primerJugador
     * @return 
     */
    private List<Jugador> ordenarJugadores(int primerJugador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * reordena la lista de jugadores al azar
     * @return 
     */
    private List<Jugador> ordenarJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
