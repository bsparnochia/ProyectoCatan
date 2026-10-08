/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Entities.Fases.FaseConfiguracionJugador;
import Entities.Fases.FaseColocacionInicial;
import Entities.CargaInicial.TarjetaCostos.TarjetaDeCostes;
import Entities.ConfiguracionMapa;
import Entities.CargaInicial.TarjetaCostos.CargaTarjetaDeCostes;
import Entities.Cartografia.Cartografo;
import Entities.CreadorJugador;
import Entities.EstadosPartida.HistorialDeProgresos;
import Entities.Juego;
import Entities.Jugador.Jugador;
import Entities.SelectoresDeEntradaDeDatos.SelectorColocacionCoordenadasDePrueba;
import Entities.SelectoresDeEntradaDeDatos.SelectorColocacionTeclado;
import Interfaces.I_SelectorColocacion;
import java.util.List;

/**
 *
 * @author Brian
 */
public class ProyectoCatan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConfiguracionMapa mapaInicial = new ConfiguracionMapa();
        Cartografo cartografo = mapaInicial.configurarMapa();
        TarjetaDeCostes tarjeta = new CargaTarjetaDeCostes().generarTarjetaDeCostes();
        List<Jugador> listaJugadores = new CreadorJugador().faseCreacionJugadoresPrueba();

        FaseConfiguracionJugador configuracionJugador = new FaseConfiguracionJugador(listaJugadores);
        configuracionJugador.ordenarJugadores();
        configuracionJugador.mostrarJugadoresOrdenados();

        HistorialDeProgresos registroProgreso = new HistorialDeProgresos(listaJugadores);
        //I_SelectorColocacion selector = new SelectorColocacionTeclado();
        DatosDePrueba d = new DatosDePrueba();
        I_SelectorColocacion selector = new SelectorColocacionCoordenadasDePrueba(d.crearCoordenadasUbicacionDeFaseColocacion(),
                d.crearCoordenadasCaminoDeFaseColocacion());
        FaseColocacionInicial colocacionInicial = new FaseColocacionInicial(cartografo, listaJugadores,
                registroProgreso,selector);
        colocacionInicial.realizarColocacion();

        /**
         * parte de testeo temporal*
         */
        cartografo.mostrarMapa();
        configuracionJugador.mostrarJugadoresOrdenados();
        registroProgreso.mostrarRegistro();

        Juego catan = new Juego(listaJugadores, cartografo, tarjeta, registroProgreso);
        catan.jugar();
    }

}
