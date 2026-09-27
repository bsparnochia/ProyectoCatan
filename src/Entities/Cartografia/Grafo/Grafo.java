/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Grafo;

import Entities.Cartografia.Camino;
import Entities.Cartografia.Ubicacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class Grafo {
    private List<Ubicacion> listaUbicaciones;
    private Camino[][] matrizAdy;
    private int cantidadUbicaciones;
    private static final int POSICION_INEXISTENTE = -1;
    private static final int CANTIDAD_UBICACIONES_DEFAULT = 54;

    public Grafo(List<Ubicacion> listaVertice, int cantidadVertices) {
        this.listaUbicaciones = listaVertice;
        this.matrizAdy = new Camino[cantidadVertices][cantidadVertices];
        this.cantidadUbicaciones = cantidadVertices;
    }
    
    public Grafo(){
        this.listaUbicaciones = new ArrayList<>();
        this.matrizAdy = new Camino[CANTIDAD_UBICACIONES_DEFAULT][CANTIDAD_UBICACIONES_DEFAULT];
        this.cantidadUbicaciones = CANTIDAD_UBICACIONES_DEFAULT;
    }

    /**
     * Busca el vertice en el listado de vertices del Grafo
     * @param buscado
     * @return posicion = -1 si no lo encuentra, sino posicion >= 0
     */
    public int buscarUbicacion(int buscado){
        boolean encontrado=false;
        int posicion=-1;// por defecto no la encontro
        int i=0;
        while(!encontrado && i<this.listaUbicaciones.size()){
            int actual = this.listaUbicaciones.get(i).getId();
            if(buscado==actual){
                encontrado=true;
                posicion=i;
            }else{i++;}
        }
        return posicion;       
    }
    
    private boolean existeUbicacion(int nuevo){
        return this.buscarUbicacion(nuevo) != POSICION_INEXISTENTE;
    }
    
    
    public void agregarUbicacion(int a) throws Exception{
        if (!this.existeUbicacion(a)){
            this.listaUbicaciones.add(new Ubicacion(a));
        }else{
            throw new Exception ("Ya existe el vertice!");
        }
    }
    
    public int getCantidadVertices(){
        return this.listaUbicaciones.size();
    }

    /**
     * Busca el arista segun un origen y un destino
     * @param origen
     * @param destino
     * @return devuelve una arista si encuentra resultado sino null
     * @throws Exception 
     */
    public Camino buscarCamino(int origen, int destino){
        Camino buscado = null;
        try {
            int posOrigen = this.buscarUbicacion(origen);
            int posDestino = this.buscarUbicacion(destino);
            if (this.existeUbicacion(origen) && this.existeUbicacion(destino)) {
                buscado = this.matrizAdy[posOrigen][posDestino];
            } else {
                throw new Exception("no existe uno o ambos vertices!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return buscado;
    }
    
    private boolean existeCamino(int origen, int destino){
        return this.buscarCamino(origen, destino) != null;
    }
    
    public void agregarCamino(int id, int origen, int destino) throws Exception{
        if (!this.existeCamino(origen, destino)){
            int posOrigen = this.buscarUbicacion(origen);
            int posDestino = this.buscarUbicacion(destino);
            Ubicacion verticeOrigen = this.listaUbicaciones.get(posOrigen);
            Ubicacion verticeDestino = this.listaUbicaciones.get(posDestino);
            this.matrizAdy[posOrigen][posDestino] = new Camino(id,verticeOrigen,verticeDestino);
            this.matrizAdy[posDestino][posOrigen] = new Camino(id,verticeDestino,verticeOrigen);
        }else{
            throw new Exception("ya existe la aristaaaaa");
        }
        
    }
    
    public void mostrarVertices(){
        for (Ubicacion v: this.listaUbicaciones){
            System.out.println(v.toString());
        }
    }

    public void mostrarAristas() {
        for (int i=0; i<this.cantidadUbicaciones; i++){
            for (int j=0; j<this.cantidadUbicaciones; j++){
                Camino actual = this.matrizAdy[i][j];
                if (actual != null)
                    System.out.println(actual.toString());
            }
        }
    }
}
