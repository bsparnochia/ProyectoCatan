/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.Cartografia.Visual;

import Enumerados.Color;
import Enumerados.Recurso;

/**
 * Clase encargada de pintar los elementos del mapa
 *
 * @author Brian
 */
public class Dibujante {

    private static final String BORRARC = "\u001B[0m";
    private static final String BORRAR = "\033[0m";
  
    //Elementos de final colores
    private static final String ELEMENTO_NEGRO = "\033[30m";
    private static final String ELEMENTO_ROJO = "\033[31m";
    private static final String ELEMENTO_VERDE = "\033[32m";
    private static final String ELEMENTO_AMARILLO = "\033[33m";
    private static final String ELEMENTO_AZUL = "\033[34m";
    private static final String ELEMENTO_BLANCO = "\033[37m";
  
    //Fondos de co final ores
//    private stat final c String FONDO_NEGRO = "\033[40m";
    private static final String FONDO_NEGRO = "\033[48;2;0;0;0m";
    private static final String FONDO_ROJO = "\033[41m";
    private static final String FONDO_VERDE = "\033[42m";
    private static final String FONDO_AZUL = "\033[44m";
    private static final String FONDO_AMARILLO = "\033[43m";
    private static final String FONDO_AMARILLOC = "\033[48;5;220m";
    private static final String FONDO_AGUA = "\033[46m";
    private static final String FONDO_GRIS = "\033[47m";
    private static final String FONDO_BORDO = "\u001B[38;5;88m";
    private static final String FONDO_MARRON = "\u001B[38;5;130m";
    private static final String FONDO_VIOLETA = "\u001B[45m";  
      
    //Colores "Col final r" de recursos
    private static final String COLOR_ARCILLA = FONDO_ROJO;
    private static final String COLOR_MADERA = FONDO_VIOLETA;
    private static final String COLOR_OVEJA = FONDO_VERDE;
    private static final String COLOR_TRIGO = FONDO_AMARILLO;
    private static final String COLOR_PIEDRA = FONDO_GRIS;
    private static final String COLOR_DESIERTO = ELEMENTO_ROJO;

    /**
     * Pinta un elemento del mapa segun su estado
     *
     * @param elemento
     * @return Devuelve "dibujo" pintado
     */
    public String pintarElementoEstructura(ElementoLienzo elemento) {
        String dibujo = elemento.getSimbolo();

        switch (dibujo) {
            case "*":
                dibujo = FONDO_AGUA + dibujo + BORRAR;
                break;
            case "/":
            case "\\":
            case "|":
                dibujo = dibujo + BORRAR;
                break;
            case "U":
                dibujo = dibujo + BORRAR;
                break;
        }

        if (elemento.estaOcupada()) {
            dibujo = this.pintarSegunColor(elemento.getSimbolo(), elemento.getColor());
        }

        if (elemento.getSimbolo().matches("[0-9]{2,}|J|J1|J2|J3|J4")) {
            dibujo = dibujo + "";
        } else {
            dibujo = dibujo + " ";
        }
        return dibujo + " ";
    }

    public String pintarSegunColor(String dibujo, Color color) {

        switch (color) {
            case Color.ROJO:
                dibujo = FONDO_ROJO + dibujo + BORRAR;
                break;
            case Color.AMARILLO:
                dibujo = FONDO_AMARILLO + dibujo + BORRAR;
                break;
            case Color.AZUL:
                dibujo = FONDO_AZUL + dibujo + BORRAR;
                break;
            case Color.VERDE:
                dibujo = FONDO_VERDE + dibujo + BORRAR;
                break;
        }
        return dibujo;
    }

    Color getColorSegunRecurso(Recurso recurso) {
        Color color;
        switch (recurso) {
            case Recurso.ARCILLA:
                color = Color.ARCILLA;
                break;
            case Recurso.MADERA:
                color = Color.MADERA;
                break;
            case Recurso.OVEJA:
                color = Color.OVEJA;
                break;
            case Recurso.PIEDRA:
                color = Color.PIEDRA;
                break;
            case Recurso.TRIGO:
                color = Color.TRIGO;
                break;
            default:
                color = Color.NEGRO;

        }
        return color;
    }

    public String pintarElementoNumeroLoseta(ElementoLienzo elemento) {
        Color color = elemento.getColor();
        String dibujo = elemento.getSimbolo();

        switch (color) {
            case Color.ARCILLA:
                dibujo = COLOR_ARCILLA + dibujo + BORRAR;
                break;
            case Color.MADERA:
                dibujo = COLOR_MADERA + dibujo + BORRAR;
                break;
            case Color.OVEJA:
                dibujo = COLOR_OVEJA + dibujo + BORRAR;
                break;
            case Color.PIEDRA:
                dibujo = COLOR_PIEDRA + dibujo + BORRAR;
                break;
            case Color.TRIGO:
                dibujo = COLOR_TRIGO + dibujo + BORRAR;
                break;
            default:
                dibujo = COLOR_DESIERTO + dibujo + BORRAR;
                break;

        }

        if (elemento.getSimbolo().matches("[0-9]{2,}|J|J1|J2|J3|J4")) {
            dibujo = dibujo + "";
        } else {
            dibujo = dibujo + " ";
        }
        return dibujo + " ";
    }

    String pintarElementoCamino(ElementoLienzo elemento) {
        String dibujo = this.pintarSegunColor(elemento.getSimbolo(), elemento.getColor());
        if (elemento.getSimbolo().matches("[0-9]{2,}|J|J1|J2|J3|J4")) {
            dibujo = dibujo + "";
        } else {
            dibujo = dibujo + " ";
        }
        return dibujo + " ";
    }

    /**
     * Forma de pintar el lienzo by Colo
     *
     * @param elemento
     * @param i
     * @param j
     * @return
     */
    public String pintarElementoEstructura(ElementoLienzo elemento, int i, int j) {
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

                switch (coordY) {
                    case 6:
                        if (coordX == 1) {
                            espacioL = FONDO_AZUL + " " + BORRARC;
                        }
                        if (coordX == 21) {
                            espacioR = FONDO_AZUL + " " + BORRARC;
                        }
                        break;
                }

                break;
            case "*":
                switch (coordY) {
                    case 1, 11:
                        if (coordX == 4) {
                            espacioR = "";
                        }
                        if (coordX == 18) {
                            espacioL = "";
                        }
                        break;
                    case 2, 10:
                        if (coordX == 4) {
                            espacioR = "  ";
                        }
                        if (coordX == 18) {
                            espacioL = "  ";
                        }
                        break;
                    case 3, 9:
                        if (coordX == 2) {
                            espacioR = "";
                        }
                        if (coordX == 20) {
                            espacioL = "";
                        }
                        break;
                    case 4, 8:
                        if (coordX == 2) {
                            espacioR = "  ";
                        }
                        if (coordX == 20) {
                            espacioL = "  ";
                        }
                        break;
                }
                fuente = FONDO_AGUA + ELEMENTO_NEGRO;
                break;
            case "U":
                espacioL = "  ";
                espacioR = "  ";

                switch (coordY) {
                    case 5, 7:
                        if (coordX == 1) {
                            espacioL = " ";
                        }
                        if (coordX == 21) {
                            espacioR = " ";
                        }
                        break;
                }
                fuente = FONDO_NEGRO + ELEMENTO_BLANCO;
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
                fuente = FONDO_AMARILLOC + ELEMENTO_NEGRO;
                break;
        }

        return fuente + espacioL + dibujo + espacioR + BORRARC;
    }

}
