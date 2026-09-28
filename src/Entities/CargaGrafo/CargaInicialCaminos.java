/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaGrafo;

import Entities.Cartografia.Grafo.Camino;
import Entities.Cartografia.Grafo.Ubicacion;
import Entities.Cartografia.Visual.ElementoLienzo;
import Entities.Cartografia.Visual.Lienzo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class CargaInicialCaminos {
    
    private List<Camino> caminos;
    private List<Ubicacion> ubicaciones;
    private Lienzo lienzo;

    public CargaInicialCaminos(List<Ubicacion> ubicaciones,Lienzo lienzo) {
        this.lienzo = lienzo;
        this.caminos = new ArrayList<>();
        this.ubicaciones = ubicaciones;
    }
    
    /**
     * genera un listado de ubicacioones segun la representacion de la matriz ElementoLienzo
     * @return devuelve Lista de caminos
     */
    public List<Camino> generarListadoCaminos(){
        for(int i=0; i<lienzo.getAltoLienzo(); i++){
            for(int j=0; j<lienzo.getAnchoLienzo(); j++){
                ElementoLienzo elemento= lienzo.getElementoXcoordenada(i, j);
                if(esCamino(elemento)){
                    Camino nuevo = parsearCaminoLienzo(elemento,i,j);
                    this.caminos.add(nuevo);
                }
            }
        }
        
        return caminos;
    }
    
    public void mostrarListadoCaminos(){
        System.out.println("--LISTADO CAMINOS, CARGA-INICIAL-CAMINOS--");
        System.out.println("CANTIDAD CAMINOS CREADOS: "+this.caminos.size());
        for(Camino u:this.caminos ){
            System.out.println(u.toString());
        }
    }

    private boolean esCamino(ElementoLienzo elemento) {
        String caracter = elemento.getSimbolo();
        boolean coincidencia = false;
        
        switch (caracter){
            case "/":coincidencia= true;break;
            case "\\":coincidencia= true;break;
            case "|":coincidencia= true;break;
        }
        return coincidencia;
    }

    private Camino parsearCaminoLienzo(ElementoLienzo elemento, int i, int j) {
        String caracter = elemento.getSimbolo();
        int iOrigen = i;
        int jOrigen = j;
        
        int iDestino = i;
        int jDestino = j;
        
        
        switch (caracter){
            case "/":jOrigen-= 1; jDestino+= 1; break;
            case "\\":jOrigen-= 1; jDestino+= 1; break;
            case "|":iOrigen-=1; iDestino+=1;break;
        }
        
        Ubicacion origen = this.getUbicacionXid(this.lienzo.getIdXcoordenada(iOrigen, jOrigen));
        Ubicacion destino = this.getUbicacionXid(this.lienzo.getIdXcoordenada(iDestino, jDestino));
        
        return new Camino(elemento.getId(), origen, destino);
    }   
    
    private Ubicacion getUbicacionXid(int id){
        return this.ubicaciones.stream().filter(u -> u.getId() == id ).findFirst().get();
    }
    
}
