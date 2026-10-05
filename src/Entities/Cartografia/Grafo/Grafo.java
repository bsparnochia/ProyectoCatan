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

    private List<Ubicacion> listaUbicaciones;
    private List<Camino> listaCaminos;
    private Camino[][] matrizAdy;
    private int cantidadUbicaciones;
    private static final int POSICION_INEXISTENTE = -1;
    private static final int CANTIDAD_UBICACIONES_DEFAULT = 54;

    public Grafo(List<Ubicacion> listaVertice, List<Camino> listaCaminos) {
        this.listaUbicaciones = listaVertice;
        this.listaCaminos = listaCaminos;
        this.cantidadUbicaciones = listaVertice.size();
        this.matrizAdy = new Camino[this.cantidadUbicaciones][this.cantidadUbicaciones];

        try {
            for (Camino c : listaCaminos) {
                this.agregarCamino(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Ubicacion getUbicacionXid(int id){
        return this.listaUbicaciones.get(this.buscarUbicacion(id));
    }
    
    public Camino getCaminoXid(int id){
        return this.listaCaminos.get(this.buscarCamino(id));
    }
    
    /**
     * Busca el vertice en el listado de vertices del Grafo
     *
     * @param buscado
     * @return posicion = -1 si no lo encuentra, sino posicion >= 0
     */
    public int buscarUbicacion(int buscado) {
        boolean encontrado = false;
        int posicion = -1;// por defecto no la encontro
        int i = 0;
        while (!encontrado && i < this.listaUbicaciones.size()) {
            int actual = this.listaUbicaciones.get(i).getId();
            if (buscado == actual) {
                encontrado = true;
                posicion = i;
            } else {
                i++;
            }
        }
        return posicion;
    }

    public boolean existeUbicacion(int nuevo) {
        return this.buscarUbicacion(nuevo) != POSICION_INEXISTENTE;
    }

    public void agregarUbicacion(int a) throws Exception {
        if (!this.existeUbicacion(a)) {
            this.listaUbicaciones.add(new Ubicacion(a));
        } else {
            throw new Exception("Ya existe el vertice!");
        }
    }

    public int getCantidadVertices() {
        return this.listaUbicaciones.size();
    }

    /**
     * Busca el arista segun su ID
     *
     * @param origen
     * @param destino
     * @return devuelve una arista si encuentra resultado sino null
     * @throws Exception
     */
    private int buscarCamino(int buscado) {
        boolean encontrado = false;
        int posicion = -1;// por defecto no la encontro
        int i = 0;
        while (!encontrado && i < this.listaCaminos.size()) {
            int actual = this.listaCaminos.get(i).getIdCamino();
            if (buscado == actual) {
                encontrado = true;
                posicion = i;
            } else {
                i++;
            }
        }
        return posicion;
    }
    
    public Camino buscarCamino(int origen, int destino) {
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

    public boolean existeCamino(int origen, int destino) {
        return this.buscarCamino(origen, destino) != null;
    }

    public void agregarCamino(int id, int origen, int destino) throws Exception {
        if (!this.existeCamino(origen, destino)) {
            int posOrigen = this.buscarUbicacion(origen);
            int posDestino = this.buscarUbicacion(destino);
            Ubicacion verticeOrigen = this.listaUbicaciones.get(posOrigen);
            Ubicacion verticeDestino = this.listaUbicaciones.get(posDestino);
            this.matrizAdy[posOrigen][posDestino] = new Camino(id, verticeOrigen, verticeDestino);
            this.matrizAdy[posDestino][posOrigen] = new Camino(id, verticeDestino, verticeOrigen);
        } else {
            throw new Exception("ya existe la aristaaaaa");
        }

    }

    private void agregarCamino(Camino c) throws Exception {
        if (!this.existeCamino(c.getOrigen().getId(), c.getDestino().getId())) {
            int posOrigen = this.buscarUbicacion(c.getOrigen().getId());
            int posDestino = this.buscarUbicacion(c.getDestino().getId());
            Ubicacion verticeOrigen = this.listaUbicaciones.get(posOrigen);
            Ubicacion verticeDestino = this.listaUbicaciones.get(posDestino);
            this.matrizAdy[posOrigen][posDestino] = c;
            this.matrizAdy[posDestino][posOrigen] = c;
        } else {
            throw new Exception("ya existe la aristaaaaa");
        }
    }

    public void mostrarVertices() {
        System.out.println("**$**UBICACIONES GRAFO FINALES**$**");
        for (Ubicacion v : this.listaUbicaciones) {
            System.out.println(v.toString());
        }
    }

    public void mostrarAristas() {
        System.out.println("**$**CAMINOS GRAFO FINALES**$**");
        int contador=0;
        for (int i = 0; i < this.cantidadUbicaciones; i++) {
            for (int j = 0; j < this.cantidadUbicaciones; j++) {
                Camino actual = this.matrizAdy[i][j];
                if (actual != null) {
                    contador++;
                    System.out.println("contador= "+contador);
                    System.out.println(actual.toString());
                }
            }
        }
    }


}
