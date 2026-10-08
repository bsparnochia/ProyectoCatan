/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.SelectoresDeEntradaDeDatos;

import Entities.Cartografia.Visual.Coordenada;
import Interfaces.I_SelectorColocacion;
import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class SelectorColocacionTeclado implements I_SelectorColocacion {

    private final Scanner sc = new Scanner(System.in);

    @Override
    public Coordenada seleccionarUbicacion() {
        return this.ingresarCoordenada();
    }

    @Override
    public Coordenada seleccionarCamino() {
        return this.ingresarCoordenada();
    }

    private Coordenada ingresarCoordenada() {
        System.out.println("elija fila: ");
        int fila = sc.nextInt();
        fila--;
        System.out.println("elija columna: ");
        int columna = sc.nextInt();
        columna--;
        return new Coordenada(fila,columna);
    }

}
