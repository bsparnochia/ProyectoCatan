/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities.CargaLienzo;

import Entities.Cartografia.Loseta;
import Enumerados.Recurso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brian
 */
public class CargaLosetas {
    private static final String UBICACION_LOSETAS="src/Configuracion/Info_losetas.csv";
    private static final int CANTIDAD_INFO_LOSETAS = 8;
    private List<Loseta> listaLoseta;
    private List<Integer> listaId;

    public CargaLosetas() {
        this.listaLoseta = new ArrayList<>();
        this.listaId = new ArrayList<>();
    }
    
    
    
    public List<Loseta> generarLosetas(){  
        this.listaLoseta = new ArrayList();
        FileReader archivo;
        BufferedReader lector;

        try {
            archivo = new FileReader(UBICACION_LOSETAS);
            if (archivo.ready()) {

                lector = new BufferedReader(archivo);
                String linea;

                /* omito la linea de titulos */
                lector.readLine();
                while ((linea = lector.readLine()) != null) {
                    listaLoseta.add(this.parsearLoseta(linea));
                }
            } else {
                System.out.println("archivo no esta listo para ser leido");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaLoseta;
    }

    private Loseta parsearLoseta(String linea) {
        
        int inicio = 0;
        int idLoseta=0,id1=0,id2=0,id3=0,id4=0,id5=0,id6=0;
        Recurso material = Recurso.NINGUNO;
        
        //recorro cada item de la linea y lo guardo
        for(int i=0; i<CANTIDAD_INFO_LOSETAS; i++){
            int posicion = linea.indexOf(";",inicio);
            if(posicion == -1){
                posicion = linea.length();
            }
            switch(i){
                case 0: idLoseta= Integer.parseInt(linea.substring(inicio, posicion));break;
                case 1: material = this.getRecurso(linea.substring(inicio, posicion));break;
                case 2: id1 = Integer.parseInt(linea.substring(inicio, posicion));break;
                case 3: id2 = Integer.parseInt(linea.substring(inicio, posicion));break;
                case 4: id3 = Integer.parseInt(linea.substring(inicio, posicion));break;
                case 5: id4 = Integer.parseInt(linea.substring(inicio, posicion));break;
                case 6: id5 = Integer.parseInt(linea.substring(inicio, posicion));break;
                case 7: id6 = Integer.parseInt(linea.substring(inicio, posicion));break;
            }
            inicio = posicion+1;
        }
        
        //guardo ubicaciones de cada loseta en una lista
        List<Integer> ubicaciones = new ArrayList();
        ubicaciones.add(id1);
        ubicaciones.add(id2);
        ubicaciones.add(id3);
        ubicaciones.add(id4);
        ubicaciones.add(id5);
        ubicaciones.add(id6);
        
        //Verifico si es el desierto para asignar el ladron a la loseta inicial
        boolean ladron = false;
        if(material == Recurso.NINGUNO){
            ladron = true;
        }
        
        //genero la loseta con los datos obtenidos
            
        return new Loseta(idLoseta,material,ubicaciones,ladron);
    }

    private Recurso getRecurso( String material) {
        Recurso r;
        
        switch (material){
            case "trigo":r= Recurso.TRIGO;break;
            case "oveja":r= Recurso.OVEJA;break;
            case "piedra":r= Recurso.PIEDRA;break;
            case "desierto":r= Recurso.NINGUNO;break;
            case "arcilla":r= Recurso.ARCILLA;break;
            case "madera":r= Recurso.MADERA;break;
            default: r= Recurso.NINGUNO;
        }
        return r;
    }
    
    public List<Integer> getListaIdLosetas(){
        
        FileReader archivo;
        BufferedReader lector;
        
        try{
            archivo = new FileReader(UBICACION_LOSETAS);
            if (archivo.ready()){
               
               lector = new BufferedReader(archivo);
               String linea;             
               
               /* omito la linea de titulos */
               lector.readLine();
               while ((linea = lector.readLine()) !=null ){          
                   listaId.add(this.parsearInfoId(linea));
               }
            }else{
                System.out.println("archivo no esta listo para ser leido");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaId;
    }

    private int parsearInfoId(String linea) {
        int inicio = 0;
        int posicion = linea.indexOf(";",inicio);
        
        return Integer.parseInt(linea.substring(inicio, posicion));
    }
    
    public void showLosetasGeneradas(){
        for(Loseta l:this.listaLoseta){
            System.out.println(l);
        }
    }

}
