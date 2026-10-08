/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Entities.Cartografia.Visual.Coordenada;
import java.util.List;

/**
 *
 * @author Brian
 */
    public class DatosDePrueba {

        public List<Coordenada> crearCoordenadasUbicacionDeFaseColocacion(){
            List<Coordenada> ubicaciones = List.of(
                parsearCoordenadaLienzo(1,5),
                parsearCoordenadaLienzo(5,5),    
                parsearCoordenadaLienzo(7,5),    
                parsearCoordenadaLienzo(1,9)    
            );
            return ubicaciones;
        }

        public List<Coordenada> crearCoordenadasCaminoDeFaseColocacion(){
            List<Coordenada> caminos = List.of(
                parsearCoordenadaLienzo(1,6),
                parsearCoordenadaLienzo(5,6),    
                parsearCoordenadaLienzo(7,6),    
                parsearCoordenadaLienzo(2,9)    
            );
            return caminos;
        }

        private static Coordenada parsearCoordenadaLienzo(int fila, int columna){
            return new Coordenada(fila-1, columna-1);
        }

    }
