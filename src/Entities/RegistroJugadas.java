/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Entities.Cartografia.Grafo.Camino;
import Entities.Cartografia.Grafo.Ubicacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class RegistroJugadas {

    private int numeroJugador;
    private List<Ubicacion> ubicacionesConquistadas;
    private List<Camino> caminosConstruidos;
    private int cantidadPoblados;
    private int cantidadCastillos;
    private int cantidadCaminos;
    private int puntaje;

    public RegistroJugadas(int numeroJugador) {
        this.numeroJugador = numeroJugador;
        this.ubicacionesConquistadas = new ArrayList();
        this.caminosConstruidos = new ArrayList();

    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public List<Ubicacion> getUbicacionesConquistadas() {
        return ubicacionesConquistadas;
    }

    public List<Camino> getCaminosConstruidos() {
        return caminosConstruidos;
    }

    public void agregarUbicacionConquistada(Ubicacion nuevo) {
        this.ubicacionesConquistadas.add(nuevo);
        this.cantidadPoblados++;
        this.puntaje++;

    }

    public void anotarMejoraCastillo() {
        this.cantidadPoblados--;
        this.cantidadCastillos++;
        this.puntaje++;
    }

    public void agregarCaminoConstruido(Camino nuevo) {
        this.caminosConstruidos.add(nuevo);
        this.cantidadCaminos++;
        this.puntaje++;
    }

    @Override
    public String toString() {
        return "RegistroJugadas{" + "N=" + numeroJugador + ", \nubicacionesConquistadas=" + ubicacionesConquistadas + ", \ncaminosConstruidos=" + caminosConstruidos + ", \ncantidadPoblados=" + cantidadPoblados + ", cantidadCastillos=" + cantidadCastillos + ", cantidadCaminos=" + cantidadCaminos + '}';
    }

}
