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

    private static String borrarC = "\u001B[0m";
    private static String borrar = "\033[0m";
    
    //Elementos de colores
    private static String elementoNegro = "\033[30m";
    private static String elementoRojo = "\033[31m";
    private static String elementoVerde = "\033[32m";
    private static String elementoAmarillo = "\033[33m";
    private static String elementoAzul = "\033[34m";
    private static String elementoBlanco = "\033[37m";

    //Fondos de colores
//    private static String fondoNegro = "\033[40m";
    private static String fondoNegro = "\033[48;2;0;0;0m"; 
    private static String fondoRojo = "\033[41m";
    private static String fondoVerde = "\033[42m";
    private static String fondoAzul = "\033[44m";
    private static String fondoAmarillo = "\033[43m";
    private static String fondoAmarilloC = "\033[48;5;220m";
    private static String fondoAgua = "\033[46m";
    private static String fondoGris = "\033[47m";

    /**
     * Pinta un elemento del mapa segun su estado
     * @param elemento
     * @return Devuelve "dibujo" pintado
     */
    public String pintarElemento(ElementoLienzo elemento) {
        String dibujo = elemento.getSimbolo();
        
        switch(dibujo){
            case "*": dibujo =fondoAzul + dibujo + borrar;break;
            case "/": 
            case "\\": 
            case "|": dibujo= dibujo+borrar;break;
            case "U": dibujo= fondoRojo + elementoBlanco + dibujo+ borrar;break;
            case "7": dibujo= fondoVerde+dibujo+borrar;break;
            default: dibujo= fondoAmarillo + elementoNegro + dibujo+borrar;break;
        }  
        if (elemento.getSimbolo().matches("[0-9]{2,}")) {
            dibujo= dibujo+"    ";
        }
        else{
            dibujo= dibujo+"  ";
        }
    return dibujo;
    }
    
    /**
     * Forma de pintar el lienzo by Colo
     * @param elemento
     * @param i
     * @param j
     * @return 
     */
    public  String pintarElemento(ElementoLienzo elemento, int i, int j) {
        String dibujo = elemento.getSimbolo();
        String fuente = "";
        String espacioL = " ";
        String espacioR = " ";
        
		// Ajusto aca para usar los mismos códigos que el dibujo generado
        int coordY = i + 1;
		int coordX = j + 1;

		// el estandar es un espacio a cada lado (" * ")
        espacioL = " ";
        espacioR = " ";

        // --- ASIGNACIÓN DE COLORES MEDIANTE ANSI ESCAPE ---
        switch (dibujo) {
            case "/":
            case "\\": 
				fuente = "";
                espacioL = ""; 
				espacioR = ""; 
                break;
			case "|": 
				fuente = "";
                espacioL = ""; 
				espacioR = ""; 
				
				switch(coordY){
					case 6:
						if (coordX ==  1){ espacioL = fondoAzul + " " + borrarC; }	
						if (coordX == 21){ espacioR = fondoAzul + " " + borrarC; }	
						break;
				}
				
                break;
            case "*": 
				switch(coordY){
					case 1,11:
						if (coordX ==  4){ espacioR = ""; }					
						if (coordX == 18){ espacioL = ""; }
						break;
					case 2,10:
						if (coordX ==  4){ espacioR = "  "; }					
						if (coordX == 18){ espacioL = "  "; }
						break;
					case 3,9:
						if (coordX ==  2){ espacioR = ""; }					
						if (coordX == 20){ espacioL = ""; }
						break;
					case 4,8:
						if (coordX ==  2){ espacioR = "  "; }					
						if (coordX == 20){ espacioL = "  "; }
						break;
				}
                fuente = fondoAzul + elementoNegro; 
                break;
            case "U": 
				espacioL = "  "; 
				espacioR = "  ";
				
				switch(coordY){
					case 5,7:
						if (coordX ==  1){ espacioL = " "; }					
						if (coordX == 21){ espacioR = " "; }
						break;
				}
                fuente = fondoNegro + elementoBlanco; 
                break;
            default: 
				if (dibujo.matches("\\d+")) {
					if (dibujo.length() == 1) {
						espacioL = "     "; 
						espacioR = "     "; 
					} else if (dibujo.length() == 2) {
						espacioL = "     "; 
						espacioR = "    ";  
					}
				}
                // Todos los números caen aca
                fuente = fondoAmarilloC + elementoNegro; 
                break;
        }
        
        return fuente + espacioL + dibujo + espacioR + borrarC;
    }
}

    


