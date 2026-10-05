/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;



import Entities.FaseConfiguracionJugador;
import Entities.FaseColocacionInicial;
import Entities.CargaInicial.TarjetaCostos.TarjetaDeCostes;
import Entities.ConfiguracionMapa;
import Entities.CargaInicial.TarjetaCostos.CargaTarjetaDeCostes;
import Entities.Cartografia.Cartografo;
import Entities.ConfiguracionRegistroJugadas;
import Entities.CreadorJugador;
import Entities.Juego;
import Entities.Jugador.Jugador;
import Entities.RegistroJugadas;
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
        
        
        
        ConfiguracionMapa mapaInicial =  new ConfiguracionMapa();
        Cartografo cartografo = mapaInicial.configurarMapa();
        TarjetaDeCostes tarjeta = new CargaTarjetaDeCostes().generarTarjetaDeCostes();
        List<Jugador> listaJugadores = new CreadorJugador().faseCreacionJugadoresPrueba();
        
                
        FaseConfiguracionJugador configuracionJugador = new FaseConfiguracionJugador(listaJugadores);
        configuracionJugador.ordenarJugadores();
        configuracionJugador.mostrarJugadoresOrdenados();
        
        ConfiguracionRegistroJugadas configuracionRegistro = new ConfiguracionRegistroJugadas(listaJugadores);
        List<RegistroJugadas> listadoRegistro = configuracionRegistro.generarListadoDeRegistroDeJugadas();
        FaseColocacionInicial colocacionInicial = new FaseColocacionInicial(cartografo, listaJugadores,listadoRegistro);
        colocacionInicial.realizarColocacion();
        cartografo.mostrarMapa();
                configuracionJugador.mostrarJugadoresOrdenados();
                configuracionRegistro.mostrarRegistro();


        
        Juego catan = new Juego(listaJugadores,cartografo,tarjeta);
//        catan.jugar();
//        catan.anunciarGanador();

    }
        
}