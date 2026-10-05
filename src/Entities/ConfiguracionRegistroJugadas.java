/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Jugador.Jugador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class ConfiguracionRegistroJugadas {
    private List<Jugador> listaJugadores;
    private List<RegistroJugadas> registro;

    public ConfiguracionRegistroJugadas(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
        this.registro = new ArrayList();
    }
    
    public List<RegistroJugadas> generarListadoDeRegistroDeJugadas(){
        for (Jugador j: this.listaJugadores){
            registro.add(new RegistroJugadas(j.getNumeroJugador()));
        }
        return registro;
    }

    public void mostrarRegistro() {
        System.out.println("CHECK REGISTRO JUGADAS");
        for(RegistroJugadas r: registro){
            System.out.println("");
            System.out.println(r.toString());
            System.out.println("");
        }
    }
}
