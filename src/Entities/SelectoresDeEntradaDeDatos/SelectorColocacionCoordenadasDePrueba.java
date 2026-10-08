/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.SelectoresDeEntradaDeDatos;

import Entities.Cartografia.Visual.Coordenada;
import Interfaces.I_SelectorColocacion;
import java.util.List;

/**
 *
 * @author Brian
 */
public class SelectorColocacionCoordenadasDePrueba implements I_SelectorColocacion {

    private List<Coordenada> coordenadasDeUbicaciones;
    private List<Coordenada> coordenadasDeCaminos;
    private int indiceUbicacion;
    private int indiceCamino;
    private static final int POSICION_INICIAL = 0;

    public SelectorColocacionCoordenadasDePrueba(List<Coordenada> coordenadasDeUbicaciones, List<Coordenada> coordenadasDeCaminos) {
        this.coordenadasDeUbicaciones = coordenadasDeUbicaciones;
        this.coordenadasDeCaminos = coordenadasDeCaminos;
        this.indiceUbicacion = POSICION_INICIAL;
        this.indiceCamino = POSICION_INICIAL;
    }

    @Override
    public Coordenada seleccionarUbicacion() {
        Coordenada actual = this.coordenadasDeUbicaciones.get(indiceUbicacion);
        this.indiceUbicacion++;
        return actual;
    }

    @Override
    public Coordenada seleccionarCamino() {
        Coordenada actual = this.coordenadasDeCaminos.get(indiceCamino);
        this.indiceCamino++;
        return actual;
    }

}
