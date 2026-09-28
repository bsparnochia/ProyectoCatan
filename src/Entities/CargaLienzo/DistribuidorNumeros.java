/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaLienzo;

import Entities.Cartografia.Coordenada;
import Entities.Cartografia.Visual.Lienzo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Brian
 */
public class DistribuidorNumeros {

    private final String[] orden;
    private int cursorOrden;
    private List<InfoLoseta> idExterior;
    private List<InfoLoseta> idInterior;
    private InfoLoseta idCentral;
    private int idLadron;
    private final String NUMERO_LADRON = "7";
    private static final String CONFIGURACION_ORDEN = "src/Configuracion/ordenColocacionLosetas.csv";
    private final int CANTIDAD_LOSETAS_EXTERIORES = 12;
    private final int CANTIDAD_LOSETAS_INTERIORES = 6;
    private List<NumeracionCatan> numeracion;
    

    public DistribuidorNumeros() {
        this.orden = new String[]{"5", "2", "6", "3", "8", "10", "9", "12", "11", "4", "8", "10", "9", "4", "5", "6", "3", "11"};
        this.generarListaId();
        this.numeracion = new ArrayList<>();
        this.cursorOrden = 0;
    }

    public String[] getOrden() {
        return orden;
    }

    public void showNumeros() {
        for (String n : orden) {
            System.out.print("[" + n + "] ");
        }
    }

    private void generarListaId() {
        //inicializo las listas de los id
        this.idExterior = new ArrayList();
        this.idInterior = new ArrayList();
        this.idCentral = null;
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader(CONFIGURACION_ORDEN);

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                //omitir encabezado
                lector.readLine();
                String linea;
                while ((linea = lector.readLine()) != null) {
                    this.guardarInfoLoseta(linea);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void guardarInfoLoseta(String linea) {
        String[] info = linea.split(";");
        String tipo = info[0];
        int id = Integer.parseInt(info[1]);
        int losetaAdyacente = Integer.parseInt(info[2]);

        switch (tipo) {
            case "e":
                this.idExterior.add(new InfoLoseta(id, losetaAdyacente));
                break;
            case "i":
                this.idInterior.add(new InfoLoseta(id, losetaAdyacente));
                break;
            case "c":
                this.idCentral = new InfoLoseta(id, losetaAdyacente);
                break;
            default:
                System.out.println("no funca che");
        }

    }

    public List<NumeracionCatan> distribuirNumerosEnLosetas(int idLadron) {

        this.idLadron = idLadron;

        int idUltimaLosetaExterior = this.ordenarExterior();
        //obtengo el ultimo id colocado para saber como seguir el anillo interno
        int inicioInterior = this.buscarAdyacente(idUltimaLosetaExterior);
        this.ordenarInterior(inicioInterior);
        this.definirLosetaCentral();

        return this.numeracion;
    }
    
    /**revisar que cursor usar!**/

    private int ordenarExterior() {
        //Lista donde se van a guardar generadas las id
        
        Random rand = new Random();
        //posicion random entre las 12 exteriores para iniciar la colocacion
        int cursorAnillo = rand.nextInt(12);
      // System.out.println("Arrancamos desde la loseta: " + this.idExterior.get(cursorAnillo).getId());

        for (int i = 0; i < this.CANTIDAD_LOSETAS_EXTERIORES; i++) {
            if (cursorAnillo == this.CANTIDAD_LOSETAS_EXTERIORES) {
                cursorAnillo = 0;
            }
            int actual = this.idExterior.get(cursorAnillo).getId();
            
            if(!this.esLosetaLadron(actual)){
                numeracion.add(new NumeracionCatan(actual, this.orden[this.cursorOrden]));
                this.cursorOrden++;
            }else{
                numeracion.add(new NumeracionCatan(actual, this.NUMERO_LADRON));                
            }
            cursorAnillo++;
        }
        
        //BORRAR LUEGO
        //this.showOrden(numeracion);
        return this.numeracion.getLast().getId();
    }

    private void ordenarInterior(int inicioInterior) {
        //Lista donde se van a guardar generadas las id
        //posicion adyacente a la ultima y entre las 6 interiores para iniciar la colocacion
        int cursorAnillo = obtenerPosicionIdInterior(inicioInterior);
        //System.out.println("Arrancamos desde la loseta: " + this.idInterior.get(cursorAnillo).getId());

        for (int i = 0; i < this.CANTIDAD_LOSETAS_INTERIORES; i++) {

            if (cursorAnillo == this.CANTIDAD_LOSETAS_INTERIORES) {
                cursorAnillo = 0;
            }
            int actual = this.idInterior.get(cursorAnillo).getId();
            if(!this.esLosetaLadron(actual)){
                numeracion.add(new NumeracionCatan(actual, this.orden[this.cursorOrden]));
                this.cursorOrden++;
            }else{
                numeracion.add(new NumeracionCatan(actual, this.NUMERO_LADRON));                
            }
            cursorAnillo++;

        }
        //BORRAR LUEGO
        //this.showOrden(numeracion);
    }

    private void definirLosetaCentral() {
        NumeracionCatan numeroCentral;

        if (!esLosetaLadron(this.idCentral.getId())) {
            numeroCentral = new NumeracionCatan(this.idCentral.getId(), this.orden[this.orden.length - 1]);
        } else {
            numeroCentral = new NumeracionCatan(this.idCentral.getId(), NUMERO_LADRON);
        }
        this.numeracion.add(numeroCentral);
        //BORRAR LUEGO
        //System.out.println("central: "+numeroCentral);
    }

    private boolean esLosetaLadron(int id) {
        return this.idLadron == id;
    }

    /**
     * Devuelve 0 si no encuentra el adyacente, sino devuelve la loseta
     * adyacente interior a la actual
     *
     * @param id
     * @return
     */
    private int buscarAdyacente(int id) {
        int ady = 0;

        for (InfoLoseta e : this.idExterior) {
            if (e.getId() == id) {
                ady = e.getLosetaAdyacenteInterior();
                return ady;
            }
        }
        return ady;
    }

    private void showOrden(List<NumeracionCatan> numeracion) {
        for (NumeracionCatan n : numeracion) {
            System.out.println(n.toString());

        }
    }

    /**
     * devuelve cero si no encuentra el id, caso contrario la posicion
     *
     * @param inicioInterior
     * @return
     */
    private int obtenerPosicionIdInterior(int inicioInterior) {
        int posicion = 0;
        for (int i = 0; i < this.idInterior.size(); i++) {
            if (this.idInterior.get(i).getId() == inicioInterior) {
                posicion = i;
                return posicion;
            }
        }
        return posicion;
    }

}
