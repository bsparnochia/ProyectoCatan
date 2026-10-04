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
public class Juego{
    
     private Cartografo mapa;
     private TarjetaDeCostes tarjeta;
     private List <Jugador> listaJugadores;
     private Jugador jugadorActual;
     private Jugador ganador;
     private Scanner sc;
     private final int NO_DEFINIDO = 0;
          
    public Juego(List<Jugador> listaJugadores, Cartografo mapa, TarjetaDeCostes tarjeta){
       this.listaJugadores = listaJugadores;
       sc = new Scanner(System.in);
       this.jugadorActual = null;
       this.ganador = null;
       this.mapa = mapa;
       this.tarjeta = tarjeta;
    }
    
    


    public void jugar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void anunciarGanador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
//
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
