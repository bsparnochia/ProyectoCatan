/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Cartografia.Visual.Dibujante;
import Entities.Cartografia.Cartografo;
import Entities.Cartografia.Grafo.Grafo;
import Entities.Cartografia.Visual.Lienzo;
import Entities.CargaInicial.TarjetaCostos.TarjetaDeCostes;
import Entities.Jugador.Jugador;
import Enumerados.ColorJugador;
import Interfaces.I_LogicaJuego;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class Juego implements I_LogicaJuego{
    
     private Cartografo mapa;
     private TarjetaDeCostes tarjeta;
     private List <Jugador> listaJugadores;
     private Jugador jugadorActual;
     private Jugador ganador;
     private Scanner sc;
     private final int NO_DEFINIDO = 0;
          
    public Juego(Cartografo mapa, TarjetaDeCostes tarjeta){
       listaJugadores = new ArrayList();
       sc = new Scanner(System.in);
       this.jugadorActual = null;
       this.ganador = null;
       this.mapa = mapa;
       this.tarjeta = tarjeta;
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
            ColorJugador color = elegirColorJugador();//implementar
            Jugador nuevoJugador = new Jugador(i,nombre,color);//creamos jugador
            this.listaJugadores.add(nuevoJugador);
        }
   }
    //genera una lista de jugadores de prueba con 2 jugadores
    public void faseCreacionJugadoresPrueba(){
        this.listaJugadores.add(new Jugador(1,"Elute",ColorJugador.ROJO));
        this.listaJugadores.add(new Jugador(2,"Pelu",ColorJugador.AZUL));
    }
    
    @Override
    public void faseEleccionOrdenJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void faseColocacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    private ColorJugador elegirColorJugador(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
//    @Override
//    public void faseEleccionOrdenJugadores() {
//        int primerJugador = NO_DEFINIDO;
//        for (Jugador jugador : this.listaJugadores){
//            System.out.println("Tirar dados! presione enter para agitar y lanzarlos con estilo");
//            sc.nextLine();
//            int resultado = jugador.tirarDados();
//            primerJugador = evaluarTirada(resultado);
//        }
//        this.listaJugadores = ordenarJugadores(primerJugador);
//        
//    }
//
//    @Override
//    public void faseColocacion() { 
//        /*Se realiza la primera ronda de colocacion de fichas en el tablero*/
//        System.out.println("--Primera Ronda de Colocacion--/n/n");
//        this.realizarRondaDeColocacionDirecta();
//        
//       /*Se realiza la segunda ronda de colocacion de fichas en el tablero con
//        con el listado de jugadores invertido segun las reglas del Catan
//        */
//        System.out.println("--Segunda Ronda de Colocacion--/n/n");
//        this.realizarRondaDeColocacionInversa();
//    }
//    
//    private void elegirUbicacionJugador(Jugador jugadorActual) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        System.out.println("-----CONSTRUCCION POBLADO INICIAL-----");
//        System.out.println("elija fila: ");
//        int fila = sc.nextInt();
//        System.out.println("elija columna: ");
//        int columna = sc.nextInt();
//        if (!this.mapa.ubicacionEstaOcupada(fila,columna)){
//            this.mapa.ocuparUbicacion(jugadorActual.getNumeroJugador(), fila, columna);
//        }
//                
//    }
//
//    private void realizarRondaDeColocacionDirecta() {
//        for (int i=0; i<this.listaJugadores.size();i++){
//            this.mapa.mostrarMapa();
//            this.elegirUbicacionJugador(this.listaJugadores.get(i));
//        }
//    }
//
//    private void realizarRondaDeColocacionInversa() {
//        int posicionInicial = this.listaJugadores.size()-1;
//        for (int i=posicionInicial; i>=-0;i--){
//            this.mapa.mostrarMapa();
//            this.elegirUbicacionJugador(this.listaJugadores.get(i));
//        }
//    }
//
//
//    @Override
//    public void jugar() { //testeando a ver como arrancamos haciendo 1 solo turno
//        for (Jugador j: this.listaJugadores){
//            this.jugadorActual = j;
//            int dados= j.tirarDados();
//            System.out.println("Jugador "+jugadorActual.getNumeroJugador()+" tiro los dados y saco un "+dados);
//            if (dados==7){
//                System.out.println("Tirada de Ladron!");
//                jugadaLadron();
//            }else{
//                System.out.println("Fase recoleccion recursos");
//                faseLevantarRecursos(jugadorActual,dados);
//                boolean terminarTurno = false;
//            
//                while (!terminarTurno){//modularizar
//                    mostrarMenuAccionesJugador();
//                    terminarTurno = elegirAccion();
//                }
//            }
//        }
//    }
//    
//    private void faseLevantarRecursos(Jugador j, int numeroLoseta) {
//        BitacoraConstrucciones bitacora = new BitacoraConstrucciones();
//        //bitacora = this.mapa.getConstruccionesSegunJugador(j.getNumeroJugador(),numeroLoseta);
//        
//        //deberia ver quien o cuanto agarra de recursos antes de sumarlos al jugador
//        //j.levantarRecursosLoseta(this.mapa.getRecursoSegunUbicacion(numeroLoseta),1);//puede ser que convenga que se defina en oootro metodo de juego. Ya qe tengo que qestar seguro de lo que envio
//    }
//
//    @Override
//    public void anunciarGanador() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//
//    private List<Jugador> ordenarJugadores(int primerJugador) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    private int evaluarTirada(int resultado) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    private void jugadaLadron() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    private void mostrarMenuAccionesJugador() {
//        System.out.println("**** ACCIONES ******");
//        System.out.println("1-TRADEAR RECURSOS");
//        System.out.println("2-CONSTRUIR");
//        System.out.println("3-COMPRAR RECURSOS BANCO");
//        System.out.println("4-TERMINAR TURNO");
//    }
//
//    private boolean elegirAccion() {
//        int opcion;
//        boolean terminarTurno = false;
//        System.out.println("ingrese una opcion: ");
//        opcion = sc.nextInt();
//        switch(opcion){
//            case 1:
//                iniciarTradeoJugadores();//usar jugadorActual
//                break;
//            case 2:
//                menuConstruccion();//usar jugadorActual
//                break;
//            case 3:
//                menuBanco();//usar jugadorActual
//                break;
//            case 4:
//                terminarTurno = true;
//                break;
//            default:
//                System.out.println("opcion incorrecta!");
//        }
//        
//        return terminarTurno;
//    }
//
//    private void iniciarTradeoJugadores() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    private void menuConstruccion() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    private void menuBanco() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//
//

}
