/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Visual;


/**
 * Clase encargada de pintar los elementos del mapa
 * @author Brian
 */
public class Dibujante {

    private static String borrar = "\u001B[0m";
    
    //Elementos de colores
    private static String elementoNegro = "\033[30m";
    private static String elementoRojo = "\033[31m";
    private static String elementoVerde = "\033[32m";
    private static String elementoAmarillo = "\033[33m";
    private static String elementoAzul = "\033[34m";
    private static String elementoBlanco = "\033[37m";

    //Fondos de colores
    private static String fondoNegro = "\033[40m";
    private static String fondoRojo = "\033[41m";
    private static String fondoVerde = "\033[42m";
    private static String fondoAzul = "\033[44m";
    private static String fondoAmarillo = "\033[43m";
    private static String fondoAgua = "\033[46m";
    private static String fondoGris = "\033[47m";

    /**
     * Pinta un elemento del mapa segun su estado
     * @param elemento
     * @return Devuelve "dibujo" pintado
     */
    public String pintarElemento(ElementoMapa elemento) {
        String dibujo = elemento.getSimbolo();
        
        switch(dibujo){
            case "*": dibujo =fondoAzul+dibujo+" "+borrar;break;
            case "/": dibujo= dibujo+borrar+" ";break;
            case "\\": dibujo= dibujo+borrar+" ";break;
            case "|": dibujo= dibujo+borrar+" ";break;
            case "U": dibujo= fondoRojo+elementoBlanco+dibujo+borrar+" ";break;
            case "7": dibujo= fondoVerde+dibujo+borrar+" ";break;
            default: dibujo= fondoAmarillo+dibujo+" "+borrar;break;
        }  
     return dibujo;
    }

}
