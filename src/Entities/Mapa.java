/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.Recurso;
import java.util.List;

/**
 *
 * @author Brian
 */
public class Mapa {
    Ubicacion[][] listaLugares;
    List<Camino> listaCaminos;
    List<Loseta> listaLozetas;
    Loseta LosetaLadron;

    public Mapa(Ubicacion[][] listaLugares, List<Camino> listaCaminos, List<Loseta> listaLozetas, Loseta LosetaLadron) {
        this.listaLugares = listaLugares;
        this.listaCaminos = listaCaminos;
        this.listaLozetas = listaLozetas;
        this.LosetaLadron = LosetaLadron;
    }

    
    void mostrarMapa(){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void generarLozetas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Recurso getRecursoSegunUbicacion(int dados){
        Recurso r= Recurso.TRIGO; //terminar, esta hecho basico para que funcione para probar codigo
        return r;
    }
    
    public List<Loseta> getLosetasAdyacentes(Coordenada cord){
        return null;
    }
    
}
