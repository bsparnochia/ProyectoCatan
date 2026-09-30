/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaInicial.CargaGrafo;

import Entities.Cartografia.Grafo.Ubicacion;
import Entities.Cartografia.Visual.ElementoLienzo;
import Entities.Cartografia.Visual.Lienzo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class CargaInicialUbicaciones {

    private Lienzo lienzo;
    private List<Ubicacion> listado;

    public CargaInicialUbicaciones(Lienzo lienzo) {
        this.lienzo = lienzo;
        this.listado = new ArrayList<>();
    }

    /**
     * genera un listado de ubicacioones segun la representacion de la matriz
     * ElementoLienzo
     *
     * @param mapaInicial
     * @param alto
     * @param ancho
     * @return devuelve List<ubicacion>
     */
    public List<Ubicacion> generarListadoUbicaciones(ElementoLienzo[][] mapaInicial, int alto, int ancho) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                ElementoLienzo elemento = mapaInicial[i][j];
                if (esUbicacion(elemento)) {
                    this.listado.add(new Ubicacion(elemento.getId()));
                }
            }
        }

        return listado;
    }

    public List<Ubicacion> generarListadoUbicaciones() {
        for (int i = 0; i < lienzo.getAltoLienzo(); i++) {
            for (int j = 0; j < lienzo.getAnchoLienzo(); j++) {
                ElementoLienzo elemento = lienzo.getElementoXcoordenada(i, j);
                if (esUbicacion(elemento)) {
                    this.listado.add(new Ubicacion(elemento.getId()));
                }
            }
        }

        return listado;
    }

    public void mostrarListadoUbicaciones() {
        System.out.println("--LISTADO UBICACIONES, CARGA-INICIAL-UBICACIONES--");
        System.out.println("CANTIDAD UBICACIONES CREADOS: " + this.listado.size());
        for (Ubicacion u : this.listado) {
            System.out.println(u.toString());
        }
    }

    private boolean esUbicacion(ElementoLienzo elemento) {
        return elemento.getSimbolo().contains("U");
    }

}
