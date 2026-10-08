/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entities.Cartografia.Visual.Coordenada;

/**
 *
 * @author Brian
 */
public interface I_SelectorColocacion {
    
    /**
     * Devuelve una coordenada de una ubicacion elegida
     * @return 
     */
    public Coordenada seleccionarUbicacion();
    
    /**
     * Devuelve una coordenada de un camino elegido
     * @return 
     */
    public Coordenada seleccionarCamino();
    

}
