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
        
        TarjetaDeCostes tarjeta = new TarjetaDeCostes(new CostoCamino(), new CostoPoblado(), new CostoCastillo());
        mostrarInfoTarjeta(tarjeta);
        return tarjeta;
    }

    public Ubicacion[][] generarUbicaciones() {
        
        Ubicacion[][] ubicaciones = new Ubicacion[ALTO_MAPA][ANCHO_MAPA];
      
            ubicaciones[0][0] = new Ubicacion(Superficie.AGUA,1);//tipo de superficie + id
      ubicaciones[0][1] = new Ubicacion(Superficie.AGUA,2);
      ubicaciones[0][2] = new Ubicacion(Superficie.TIERRA,3);
      ubicaciones[0][3] = new Ubicacion(Superficie.TIERRA,4);
      ubicaciones[0][4] = new Ubicacion(Superficie.TIERRA,5);
      ubicaciones[0][5] = new Ubicacion(Superficie.TIERRA,6);
      ubicaciones[0][6] = new Ubicacion(Superficie.TIERRA,7);
      ubicaciones[0][7] = new Ubicacion(Superficie.TIERRA,8);
      ubicaciones[0][8] = new Ubicacion(Superficie.TIERRA,9);
      ubicaciones[0][9] = new Ubicacion(Superficie.AGUA,10);
      ubicaciones[0][10] = new Ubicacion(Superficie.AGUA,11);
            ubicaciones[1][0] = new Ubicacion(Superficie.AGUA,12);
      ubicaciones[1][1] = new Ubicacion(Superficie.TIERRA,13);
      ubicaciones[1][2] = new Ubicacion(Superficie.TIERRA,14);
      ubicaciones[1][3] = new Ubicacion(Superficie.TIERRA,15);
      ubicaciones[1][4] = new Ubicacion(Superficie.TIERRA,16);
      ubicaciones[1][5] = new Ubicacion(Superficie.TIERRA,17);
      ubicaciones[1][6] = new Ubicacion(Superficie.TIERRA,18);
      ubicaciones[1][7] = new Ubicacion(Superficie.TIERRA,19);
      ubicaciones[1][8] = new Ubicacion(Superficie.TIERRA,20);
      ubicaciones[1][9] = new Ubicacion(Superficie.TIERRA,21);
      ubicaciones[1][10] = new Ubicacion(Superficie.AGUA,22);
             ubicaciones[2][0] = new Ubicacion(Superficie.TIERRA,23);
      ubicaciones[2][1] = new Ubicacion(Superficie.TIERRA,24);
      ubicaciones[2][2] = new Ubicacion(Superficie.TIERRA,25);
      ubicaciones[2][3] = new Ubicacion(Superficie.TIERRA,26);
      ubicaciones[2][4] = new Ubicacion(Superficie.TIERRA,27);
      ubicaciones[2][5] = new Ubicacion(Superficie.TIERRA,28);
      ubicaciones[2][6] = new Ubicacion(Superficie.TIERRA,29);
      ubicaciones[2][7] = new Ubicacion(Superficie.TIERRA,30);
      ubicaciones[2][8] = new Ubicacion(Superficie.TIERRA,31);
      ubicaciones[2][9] = new Ubicacion(Superficie.TIERRA,32);
      ubicaciones[2][10] = new Ubicacion(Superficie.TIERRA,33);
            ubicaciones[3][0] = new Ubicacion(Superficie.TIERRA,34);
      ubicaciones[3][1] = new Ubicacion(Superficie.TIERRA,35);
      ubicaciones[3][2] = new Ubicacion(Superficie.TIERRA,36);
      ubicaciones[3][3] = new Ubicacion(Superficie.TIERRA,37);
      ubicaciones[3][4] = new Ubicacion(Superficie.TIERRA,38);
      ubicaciones[3][5] = new Ubicacion(Superficie.TIERRA,39);
      ubicaciones[3][6] = new Ubicacion(Superficie.TIERRA,40);
      ubicaciones[3][7] = new Ubicacion(Superficie.TIERRA,41);
      ubicaciones[3][8] = new Ubicacion(Superficie.TIERRA,42);
      ubicaciones[3][9] = new Ubicacion(Superficie.TIERRA,43);
      ubicaciones[3][10] = new Ubicacion(Superficie.TIERRA,44);
            ubicaciones[4][0] = new Ubicacion(Superficie.AGUA,45);
      ubicaciones[4][1] = new Ubicacion(Superficie.TIERRA,46);
      ubicaciones[4][2] = new Ubicacion(Superficie.TIERRA,47);
      ubicaciones[4][3] = new Ubicacion(Superficie.TIERRA,48);
      ubicaciones[4][4] = new Ubicacion(Superficie.TIERRA,49);
      ubicaciones[4][5] = new Ubicacion(Superficie.TIERRA,50);
      ubicaciones[4][6] = new Ubicacion(Superficie.TIERRA,51);
      ubicaciones[4][7] = new Ubicacion(Superficie.TIERRA,52);
      ubicaciones[4][8] = new Ubicacion(Superficie.TIERRA,53);
      ubicaciones[4][9] = new Ubicacion(Superficie.TIERRA,54);
      ubicaciones[4][10] = new Ubicacion(Superficie.AGUA,55);
            ubicaciones[5][0] = new Ubicacion(Superficie.AGUA,56);
      ubicaciones[5][1] = new Ubicacion(Superficie.AGUA,57);
      ubicaciones[5][2] = new Ubicacion(Superficie.TIERRA,58);
      ubicaciones[5][3] = new Ubicacion(Superficie.TIERRA,59);
      ubicaciones[5][4] = new Ubicacion(Superficie.TIERRA,60);
      ubicaciones[5][5] = new Ubicacion(Superficie.TIERRA,61);
      ubicaciones[5][6] = new Ubicacion(Superficie.TIERRA,62);
      ubicaciones[5][7] = new Ubicacion(Superficie.TIERRA,63);
      ubicaciones[5][8] = new Ubicacion(Superficie.TIERRA,64);
      ubicaciones[5][9] = new Ubicacion(Superficie.AGUA,65);
      ubicaciones[5][10] = new Ubicacion(Superficie.AGUA,66);

      
      
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

    private void mostrarInfoTarjeta(TarjetaDeCostes tarjeta) {
        System.out.println(tarjeta.toString());
    }
}
