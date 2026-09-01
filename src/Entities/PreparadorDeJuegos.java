/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import Enumerados.Superficie;

/**
 *
 * @author Brian
 */
public class PreparadorDeJuegos {
    //esta clase se encarga de leer el archivo de texto y preparar el juego!
    private static final int ANCHO_MAPA = 11;
    private static final int ALTO_MAPA = 6;
    private static final int PRIMER_POSICION = 0;

    public PreparadorDeJuegos() {
    }

//    public Mapa generarMapa() {
//        Ubicacion[][] ubicaciones = generarUbicaciones();
//    }
    
        public TarjetaDeCostes generarTarjetaDeCostes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Ubicacion[][] generarUbicaciones() {
        
        Ubicacion[][] ubicaciones = new Ubicacion[ALTO_MAPA][ANCHO_MAPA];
      
            ubicaciones[0][0] = new Ubicacion(Superficie.AGUA);
      ubicaciones[0][1] = new Ubicacion(Superficie.AGUA);
      ubicaciones[0][2] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[0][3] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[0][4] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[0][5] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[0][6] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[0][7] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[0][8] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[0][9] = new Ubicacion(Superficie.AGUA);
      ubicaciones[0][10] = new Ubicacion(Superficie.AGUA);
            ubicaciones[1][0] = new Ubicacion(Superficie.AGUA);
      ubicaciones[1][1] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][2] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][3] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][4] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][5] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][6] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][7] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][8] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][9] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[1][10] = new Ubicacion(Superficie.AGUA);
             ubicaciones[2][0] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][1] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][2] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][3] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][4] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][5] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][6] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][7] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][8] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][9] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[2][10] = new Ubicacion(Superficie.TIERRA);
            ubicaciones[3][0] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][1] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][2] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][3] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][4] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][5] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][6] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][7] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][8] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][9] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[3][10] = new Ubicacion(Superficie.TIERRA);
            ubicaciones[4][0] = new Ubicacion(Superficie.AGUA);
      ubicaciones[4][1] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][2] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][3] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][4] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][5] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][6] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][7] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][8] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][9] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[4][10] = new Ubicacion(Superficie.AGUA);
            ubicaciones[5][0] = new Ubicacion(Superficie.AGUA);
      ubicaciones[5][1] = new Ubicacion(Superficie.AGUA);
      ubicaciones[5][2] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[5][3] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[5][4] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[5][5] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[5][6] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[5][7] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[5][8] = new Ubicacion(Superficie.TIERRA);
      ubicaciones[5][9] = new Ubicacion(Superficie.AGUA);
      ubicaciones[5][10] = new Ubicacion(Superficie.AGUA);

      
      
      this.imprimirMapaUbicaciones(ubicaciones);
        
        return ubicaciones;
    }
    
    private void imprimirMapaUbicaciones(Ubicacion[][] ubicaciones){
        for (int i=PRIMER_POSICION; i<ALTO_MAPA;i++){
            for (int j=PRIMER_POSICION; j<ANCHO_MAPA; j++){
                if (ubicaciones[i][j].esAgua()){                    
                    System.out.print("* ");
                }
                else{
                    System.out.print("T ");
                }
            }
            System.out.println("\n");
        }
    }
}
