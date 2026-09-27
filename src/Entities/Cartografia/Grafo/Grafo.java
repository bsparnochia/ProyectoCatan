/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Grafo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class Grafo {
    private List<Vertice> listaVertice;
    private Arista[][] matrizAdy;
    private int cantidadVertices;
    private static final int POSICION_INEXISTENTE = -1;
    private static final int CANTIDAD_VERTICES_DEFAULT = 54;

    public Grafo(List<Vertice> listaVertice, int cantidadVertices) {
        this.listaVertice = listaVertice;
        this.matrizAdy = new Arista[cantidadVertices][cantidadVertices];
        this.cantidadVertices = cantidadVertices;
    }
    
    public Grafo(){
        this.listaVertice = new ArrayList<>();
        this.matrizAdy = new Arista[CANTIDAD_VERTICES_DEFAULT][CANTIDAD_VERTICES_DEFAULT];
        this.cantidadVertices = CANTIDAD_VERTICES_DEFAULT;
    }

    /**
     * Busca el vertice en el listado de vertices del Grafo
     * @param a
     * @return posicion = -1 si no lo encuentra, sino posicion >= 0
     */
    public int buscarVertice(String a){
        boolean encontrado=false;
        Vertice buscado = new Vertice(a);
        int posicion=-1;// por defecto no la encontro
        int i=0;
        while(!encontrado && i<listaVertice.size()){
            Vertice actual = this.listaVertice.get(i);
            if(buscado.equals(actual)){
                encontrado=true;
                posicion=i;
            }else{i++;}
        }
        return posicion;       
    }
    
    private boolean existeVertice(String a){
        return this.buscarVertice(a) != POSICION_INEXISTENTE;
    }
    
    private boolean existeVertice(int a){
        return a != POSICION_INEXISTENTE;
    }
    
    public void agregarVertice(String a) throws Exception{
        if (!this.existeVertice(a)){
            this.listaVertice.add(new Vertice(a,this.listaVertice.size()));
        }else{
            throw new Exception ("Ya existe el vertice!");
        }
    }
    
    public int getCantidadVertices(){
        return this.listaVertice.size();
    }

    /**
     * Busca el arista segun un origen y un destino
     * @param origen
     * @param destino
     * @return devuelve una arista si encuentra resultado sino null
     * @throws Exception 
     */
    public Arista buscarArista(String origen, String destino){
        Arista buscado = null;
        try {
            int idOrigen = this.buscarVertice(origen);
            int idDestino = this.buscarVertice(destino);
            if (this.existeVertice(idOrigen) && this.existeVertice(idDestino)) {
                buscado = this.matrizAdy[idOrigen][idDestino];
            } else {
                throw new Exception("no existe uno o ambos vertices!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return buscado;
    }
    
    private boolean existeArista(String origen, String destino){
        return this.buscarArista(origen, destino) != null;
    }
    
    public void agregarArista(String origen, String destino) throws Exception{
        if (!this.existeArista(origen, destino)){
            Vertice verticeOrigen = this.listaVertice.get(this.buscarVertice(origen));
            Vertice verticeDestino = this.listaVertice.get(this.buscarVertice(destino));
            this.matrizAdy[verticeOrigen.getId()][verticeDestino.getId()] = new Arista(verticeOrigen,verticeDestino);
            this.matrizAdy[verticeDestino.getId()][verticeOrigen.getId()] = new Arista(verticeDestino,verticeOrigen);
        }else{
            throw new Exception("ya existe la aristaaaaa");
        }
        
    }
    
    public void mostrarVertices(){
        for (Vertice v: this.listaVertice){
            System.out.println(v.toString());
        }
    }

    public void mostrarAristas() {
        for (int i=0; i<this.cantidadVertices; i++){
            for (int j=0; j<this.cantidadVertices; j++){
                Arista actual = this.matrizAdy[i][j];
                if (actual != null)
                    System.out.println(actual.toString());
            }
        }
    }
}
