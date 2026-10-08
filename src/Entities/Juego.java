/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Fases.FaseTirada;
import Entities.Cartografia.Cartografo;
import Entities.CargaInicial.TarjetaCostos.TarjetaDeCostes;
import Entities.EstadosPartida.HistorialDeProgresos;
import Entities.Fases.FaseChequeoEstadoJuego;
import Entities.Fases.FaseComercio;
import Entities.Fases.FaseConstruccion;
import Entities.Fases.FaseJugadaEspecial;
import Entities.Fases.FaseLadron;
import Entities.Jugador.Jugador;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class Juego {

    private FaseTirada faseTirada;
    private FaseLadron faseLadron;
    private FaseComercio faseComercio;
    private FaseConstruccion faseConstruccion;
    private FaseJugadaEspecial faseJugadaEspecial;
    private FaseChequeoEstadoJuego faseChequeo;

    private List<Jugador> listaJugadores;
    private Mensajes mensajes;
    private Jugador jugadorActual;

    public Juego(List<Jugador> listaJugadores, Cartografo mapa, TarjetaDeCostes tarjeta, HistorialDeProgresos registroProgreso) {
        this.faseTirada = new FaseTirada(mapa, listaJugadores, registroProgreso);
        this.faseLadron = new FaseLadron(mapa, listaJugadores);
        this.faseComercio = new FaseComercio(listaJugadores, tarjeta);
        this.faseConstruccion = new FaseConstruccion(mapa, listaJugadores, registroProgreso, tarjeta);
        this.faseJugadaEspecial = new FaseJugadaEspecial(mapa, listaJugadores, registroProgreso);
        this.faseChequeo = new FaseChequeoEstadoJuego(mapa,listaJugadores, registroProgreso);

        this.listaJugadores = listaJugadores;
        this.jugadorActual = null;
        this.mensajes = new Mensajes();
    }

    public void jugar() {
        boolean hayGanador = false;
        while (!hayGanador) {
            Iterator<Jugador> turno = this.listaJugadores.iterator();
            while (!hayGanador && turno.hasNext()) {
                this.jugadorActual = turno.next();
                boolean turnoTerminado = false;
                while (!turnoTerminado) {
                    this.elegirAccionInicial();
                    turnoTerminado = this.elegirOpcionMenuJuego();
                }
                //busca si el jugador llego a 10 puntos
                hayGanador = true;
            }
        }
        this.anunciarGanador(this.jugadorActual.getNombre());
    }

    private void elegirAccionInicial() {
        int opcion;
        boolean opcionIncorrecta = true;
        Scanner sc = new Scanner(System.in);

        while (opcionIncorrecta) {

            this.mensajes.mostrarMenuInicioTurnoJugador();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    this.faseTirada.lanzarDados(this.jugadorActual);
                    opcionIncorrecta = false;//usar jugadorActual
                    break;
                case 2:
                    this.faseJugadaEspecial.usarCartaEspecial(this.jugadorActual);
                    opcionIncorrecta = false;//usar jugadorActual
                    break;
                default:
                    System.out.println("opcion incorrecta!");
            }
        }
    }

    private boolean elegirOpcionMenuJuego() {
        int opcion;
        boolean terminarTurno = false;
        boolean opcionIncorrecta = true;
        Scanner sc = new Scanner(System.in);

        while (opcionIncorrecta) {

            this.mensajes.mostrarMenuAccionesJugador();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    this.faseComercio.iniciarTradeoJugadores(this.jugadorActual);
                    opcionIncorrecta = false;//usar jugadorActual
                    break;
                case 2:
                    this.faseConstruccion.menuConstruccion(this.jugadorActual);
                    opcionIncorrecta = false;//usar jugadorActual
                    break;
                case 3:
                    this.faseComercio.comerciarConBanco(this.jugadorActual);
                    opcionIncorrecta = false;//usar jugadorActual
                    break;
                case 4:
                    this.faseJugadaEspecial.usarCartaEspecial(this.jugadorActual);
                    opcionIncorrecta = false;
                    break;
                case 5:
                    terminarTurno = true;
                    opcionIncorrecta = false;
                    break;
                default:
                    System.out.println("opcion incorrecta!");
            }
        }

        return terminarTurno;
    }

    public void anunciarGanador(String nombre) {
        this.mensajes.anunciarGanador(nombre);
    }

}
//    public Juego(List<Jugador> listaJugadores, Cartografo mapa, TarjetaDeCostes tarjeta, HistorialDeProgresos registroProgreso) {
//        this.jugadorActual = null;
//
//        this.listaJugadores = listaJugadores;
//        this.mapa = mapa;
//        this.tarjeta = tarjeta;
//        this.registroProgreso = registroProgreso;
//        this.mensajes = new Mensajes();
//    }

//    public void jugar() {
//        boolean hayGanador = false;
//        while (!hayGanador) {
//            Iterator<Jugador> turno = this.listaJugadores.iterator();
//            while (!hayGanador && turno.hasNext()) {
//                this.jugadorActual = turno.next();
//                boolean turnoTerminado = false;
//                while (!turnoTerminado) {
//                    //1-JUGADA ESPECIAL
//                    //2-TIRADA Y RECOLECCION ( O LADRON)
//                    turnoTerminado = this.elegirOpcionMenuJuego();
//                }
//                //busca si el jugador llego a 10 puntos
//                ProgresoJugador registroJugador = this.registroProgreso.getProgresoSegunNumeroJugador(this.jugadorActual.getNumeroJugador());
//                if (esPuntajeGanador(registroJugador.consultarPuntaje())) {
//                    hayGanador = true;
//                    this.anunciarGanador(this.jugadorActual.getNombre());
//                }
//            }
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
//
//
//    private void jugadaLadron() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
