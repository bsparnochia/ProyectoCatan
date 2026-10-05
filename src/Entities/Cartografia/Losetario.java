/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia;

import Entities.CargaInicial.CargaLienzo.NumeracionCatan;
import Enumerados.Recurso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Encargado de agrupar las losetas del juego del catan y su informacion
 *
 * @author Brian
 */
public class Losetario {

    private List<Loseta> listaLoseta;
    private int idLadron;

    public Losetario(List<Loseta> listaLoseta) {
        this.listaLoseta = listaLoseta;
        this.idLadron = this.buscarIdLadron();
    }

    /**
     * Busca y devuelve el ID inicial del ladron de su loseta en la lista de
     * losetas
     *
     * @return Si no lo encontro devuelve cero
     */
    private int buscarIdLadron() {
        int id = 0;
        for (Loseta l : this.listaLoseta) {
            if (l.estaLadronEnLoseta()) {
                return l.getId();
            }
        }
        return id;
    }

    /**
     * Obtiene el id de la loseta donde se encuentra el ladron
     *
     * @return
     */
    public int getIdLadron() {
        return idLadron;
    }

    /**
     * Coloca al ladron en el id designado por parametro
     *
     * @param id
     */
    public void setIdLadron(int id) {
        this.idLadron = id;
    }

    /**
     * Muestra por pantalla las losetas del losetario
     */
    public void showLosetasGeneradas() {
        System.out.println("Losetas generadas: ");
        for (Loseta l : this.listaLoseta) {
            System.out.println(l);
        }
    }

    /**
     * configura los numeros que aparece en cada loseta del losetario
     *
     * @param ordenNumerosLosetario
     */
    public void configurarNumeros(List<NumeracionCatan> ordenNumerosLosetario) {
        boolean encontrado = false;
        for (NumeracionCatan nc : ordenNumerosLosetario) {
            int contador = 0;
            while (!encontrado && contador < this.listaLoseta.size()) {
                Loseta actual = this.listaLoseta.get(contador);
                if (actual.getId() == nc.getId()) {
                    actual.setNumeroLoseta(nc.getNumeroLoseta());
                    encontrado = true;
                }
                contador++;
            }
            encontrado = false;
        }
    }

    /**
     * Devuelve el numero de la loseta segun su id
     *
     * @param id
     * @return
     */
    public String getNumeroLosetaXid(int id) {
        return this.listaLoseta.stream().filter(loseta -> loseta.getId() == id).findFirst().get().getNumeroLoseta();
    }

    public List<Recurso> getRecursoXid(int id) {
        List<Recurso> recursosConseguidos = new ArrayList();
        // cuenta la cantidad de recursos que se encuentra por el id de la ubicacion a su alrededor en cada loseta que este presente
        int coincidenciasEncontradas = 0; 
        Recurso recurso = Recurso.NINGUNO;
        

        Iterator<Loseta> iterador = this.listaLoseta.iterator();
        while ((coincidenciasEncontradas<3) && iterador.hasNext()) {
            Loseta losetaActual = iterador.next();
            recurso = buscarRecursoEnLoseta(losetaActual, id);
            if (recurso != Recurso.NINGUNO) {
                recursosConseguidos.add(recurso);
                coincidenciasEncontradas++;
                System.out.println("ENCONTRE RECURSO, DESCUBRIMIENTO Nº: "+coincidenciasEncontradas);
            }
        }
        return recursosConseguidos;
    }
    
    private Recurso buscarRecursoEnLoseta(Loseta losetaActual, int idBuscado) {
        boolean encontrado = false;
        Recurso recurso = Recurso.NINGUNO;

        Iterator<Integer> iterador = losetaActual.getUbicacionesLoseta().iterator();
        while (!encontrado && iterador.hasNext()) {
            int idActual = iterador.next();
            if (idActual == idBuscado) {
                recurso = losetaActual.getRecurso();
                encontrado = true;
            }
        }
        
        return recurso;
    }

    /**
     * Devuelve la Loseta donde esta el ladron actualmente
     *
     * @return
     */
    public Loseta getLosetaLadron() {
        return this.listaLoseta.stream().filter(loseta -> loseta.estaLadronEnLoseta()).findFirst().get();
    }

    public List<Loseta> getListaLoseta() {
        return listaLoseta;
    }

}
