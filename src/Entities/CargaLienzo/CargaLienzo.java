/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaLienzo;

import Entities.Cartografia.Coordenada;
import Entities.Cartografia.Visual.ElementoLienzo;
import Entities.Cartografia.Visual.Lienzo;
import Enumerados.Zona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brian
 */
public class CargaLienzo {
    //esta clase se encarga de leer el archivo de texto y preparar el juego!
    private static final String UBICACION_MAPA="src/Configuracion/mapa_catan.csv";
    private final int ALTO_MAPA=11;
    private final int ANCHO_MAPA=21;
    ElementoLienzo[][] lienzo;

    public CargaLienzo() {
        this.lienzo = new ElementoLienzo[this.ALTO_MAPA][this.ANCHO_MAPA];
    }

    /* ------------------MAPA PARSEO--------------------- */
    
    public Lienzo generarPreLienzo(){
        //si el lienzo no existe generalo, sino devuelve el que tiene ya creado
        this.LeerArchivoLienzo();
        Map<Integer, Coordenada> tablaId = generarTablaId();
        return new Lienzo(this.lienzo, this.ALTO_MAPA,this.ANCHO_MAPA, tablaId);
    }

    
    private void LeerArchivoLienzo(){
            
        FileReader archivo;
        BufferedReader lector;
        
            try{
//              archivo = new FileReader("src/Mapas/mapa.txt");
                archivo = new FileReader(this.UBICACION_MAPA);
             if (archivo.ready()){
                lector = new BufferedReader(archivo);
                //String s;
                int caracterTXT;
                int idActual = 0;
                int i = 0;
                int j = 0;
                StringBuilder elemento = new StringBuilder();
                while ((caracterTXT = lector.read())!=-1){
                    char caracter = (char) caracterTXT;
                    if (caracter == '\n'){
                       i++;
                       j=0;
                    }
                    else if (!esDelimitador(caracter)){
                       elemento.append(caracter);
                    }else{
                        idActual++;
                        this.lienzo[i][j]= 
                                new ElementoLienzo(idActual, this.getZona(elemento.toString()),elemento.toString());
                        elemento.setLength(0);
                        j++;
                        
                   }
                }
            }else{
                System.out.println("archivo no esta listo para ser leido");
            }
        }catch(Exception e){
            System.out.println("Formato de archivo incorrecto!!!");
            e.printStackTrace();
        }
    }
    
    private boolean esDelimitador(char caracter) {
        return caracter == ';' || caracter=='\r';
    }

    private Zona getZona(String caracter) {
        
        Zona zona;
        
        switch (caracter){
            case "*":zona= Zona.AGUA;break;
            case " ":zona= Zona.TIERRA;break;
            case "U":zona= Zona.UBICACION;break;
            case "-":zona= Zona.CAMINO;break;
            case "/":zona= Zona.CAMINO;break;
            case "\\":zona= Zona.CAMINO;break;
            case "|":zona= Zona.CAMINO;break;
            case "7":zona= Zona.DESIERTO;break;
            default: zona= Zona.LOSETA;
        }
        return zona;
    }

    public int getAltoLienzo() {
        return ALTO_MAPA;
    }

    public int getAnchoLienzo() {
        return ANCHO_MAPA;
    }

    private Map<Integer,Coordenada> generarTablaId() {
        Map<Integer,Coordenada> tablaId = new HashMap<>();
        
        for (int i=0; i<ALTO_MAPA; i++){
            for (int j=0; j<ANCHO_MAPA; j++){
                Coordenada cord = new Coordenada(i,j);
                int id = this.lienzo[i][j].getId();
                tablaId.put(id, cord);
            }
        }
        return tablaId;
    }
}
