/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Visual;

import Entities.Cartografia.Coordenada;
import Entities.CargaLienzo.NumeracionCatan;
import Enumerados.Zona;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brian
 */
public class Lienzo {
    private ElementoLienzo[][] elemento;
    private int altoLienzo;
    private int anchoLienzo;
    private Map<Integer, Coordenada> tablaId;
    private Dibujante pintor;

    public Lienzo(ElementoLienzo[][] elemento, int altoLienzo, int anchoLienzo, Map<Integer, Coordenada> tablaId) {
        this.elemento = elemento;
        this.altoLienzo = altoLienzo;
        this.anchoLienzo = anchoLienzo;
        this.tablaId = tablaId;
        this.pintor = new Dibujante();
    }

    public ElementoLienzo getElementoXcoordenada(int fila, int columna) {
        return this.elemento[fila][columna];
    }
     
    public ElementoLienzo getElementoXcoordenada(Coordenada c) {
        return this.elemento[c.getFila()][c.getColumna()];
    }
    
    public int getIdXcoordenada(int fila, int columna){
        return this.elemento[fila][columna].getId();
    }
    
    public ElementoLienzo getElementoXid(int id){
        return this.getElementoXcoordenada(this.tablaId.get(id));
    }
    
    public void showTablaID(){
        System.out.println("\ntabla id:\n");
        this.tablaId.forEach((clave,valor)->
        {
            System.out.println("clave: "+clave+" valor: "+valor);
        });
    }
    
    /*
    muestra por pantalla los ID de donde estan ubicados los NUMEROS de cada loseta
    */
    public void showIDlosetas(){
        System.out.println(" ID de losetas: ");
        
        for (int i=0; i<altoLienzo; i++){
            for(int j=0; j<anchoLienzo; j++){
                if (esNumeroLoseta(this.elemento[i][j])){
                    System.out.print("["+this.elemento[i][j].getId()+"], ");
                }
            }
            System.out.println("");
        }
    }
    
    public void showIDUbicaciones(){
        System.out.println(" ID de ubicaciones: ");
        
        for (int i=0; i<altoLienzo; i++){
            for(int j=0; j<anchoLienzo; j++){
                if (esUbicacion(this.elemento[i][j])){
                    System.out.print("["+this.elemento[i][j].getId()+"] ");
                }
            }
            System.out.println("");
        }
    }
    
    public void showCoordenadalosetas(){
        System.out.println(" Coordenadas en Lienzo de losetas: ");

        for (int i=0; i<altoLienzo; i++){
            for(int j=0; j<anchoLienzo; j++){
                if (esNumeroLoseta(this.elemento[i][j])){
                    System.out.print("["+i+"]["+j+"], ");
                }
            }
            System.out.println("");
        }
    }
    
    
    public void showMapa() {
        System.out.println("");
        System.out.println("  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21");
        for (int i=0; i<this.altoLienzo; i++){
            System.out.print(i+1+" ");
            for (int j=0; j<this.anchoLienzo; j++){
                if (this.elemento[i][j]!=null){
                     System.out.print(this.elemento[i][j].getSimbolo()+" ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void showMapaPintado() {
        System.out.println("");
        System.out.println("    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21");
        for (int i=0; i<this.altoLienzo; i++){
            System.out.print(i+1+"   ");
            for (int j=0; j<this.anchoLienzo; j++){
                ElementoLienzo elemento = this.elemento[i][j];
                if (elemento!=null){
                     System.out.print(this.pintor.pintarElemento(elemento));
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    
    
/**
 * obtiene el alto del mapa
 * @return altoLienzo
 */
    public int getAltoLienzo() {
        return altoLienzo;
    }

    /**
     * obtiene el ancho del mapa
     * @return anchoLienzo
     */
    public int getAnchoLienzo() {
        return anchoLienzo;
    }

    private boolean esNumeroLoseta(ElementoLienzo elementoLienzo) {
        return elementoLienzo.getTipoZona() == Zona.LOSETA || elementoLienzo.getTipoZona() == Zona.DESIERTO;
    }

    private boolean esUbicacion(ElementoLienzo elementoLienzo) {
        return elementoLienzo.getTipoZona() == Zona.UBICACION;
    }

    /** SIN USO, POSIBLEMENTE SE BORRE
     * @return  MAP<COORDENADA,INTEGER> */
    public Map<Coordenada,Integer> getNumeroLosetaXcoordenada() {
        Map<Coordenada,Integer> mapa = new HashMap<>();
        
        for (int i=0; i<this.altoLienzo; i++){
            for (int j=0; j<this.anchoLienzo; j++){
                Coordenada cord = new Coordenada(i,j);
                if (this.elemento[i][j].getTipoZona() == Zona.LOSETA){
                    int numero = Integer.parseInt(this.elemento[i][j].getSimbolo());
                    mapa.put(cord,numero);
                }
            }
        }
        return mapa;
    }
    
    /**
     * asigna el numero de loseta segun su id
     * @param id
     * @param numero 
     */
    public void asignarNumeroLoseta(int id, String numero){
        Coordenada coordenada = this.tablaId.get(id);
        this.elemento[coordenada.getFila()][coordenada.getColumna()].setSimbolo(numero);
    }

    /**
     * configura los numeros del juego al inicio de la partida para preparar el tablero
     * @param ordenNumerosLosetario 
     */
    public void configurarNumeros(List<NumeracionCatan> ordenNumerosLosetario) {
        for (NumeracionCatan n : ordenNumerosLosetario){
            this.asignarNumeroLoseta(n.getId(), n.getNumeroLoseta());
        }
    }
    
}
