/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia;

import Entities.CargaLienzo.NumeracionCatan;
import java.util.List;

/**
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
     * Busca y devuelve el ID del ladron de su loseta en la lista de losetas
     * 
     * @return  Si no lo encontro devuelve cero
     */
    private int buscarIdLadron() {
        int id=0;
        for (Loseta l : this.listaLoseta){
            if (l.estaLadronEnLoseta()){
                return l.getId();    
            }
        }
        return id;
    }

    public int getIdLadron() {
        return idLadron;
    }
    
    public void setIdLadron(int id){
        this.idLadron = id;
    }
    
    public void showLosetasGeneradas(){
        System.out.println("Losetas generadas: ");
        for(Loseta l:this.listaLoseta){
            System.out.println(l);
        }
    }

    public void configurarNumeros(List<NumeracionCatan> ordenNumerosLosetario) {
        boolean encontrado=false;
        for(NumeracionCatan nc: ordenNumerosLosetario){
            int contador = 0;
            while(!encontrado && contador<this.listaLoseta.size()){
                Loseta actual = this.listaLoseta.get(contador);
                if(actual.getId() == nc.getId()){
                    actual.setNumeroLoseta(nc.getNumeroLoseta());
                    encontrado=true;
                }
                contador++;
            }
            encontrado=false;
        }
    }
    
    
}
