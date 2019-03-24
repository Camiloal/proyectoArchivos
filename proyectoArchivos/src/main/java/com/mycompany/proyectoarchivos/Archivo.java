/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoarchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author CamiloAlvarez
 */
public class Archivo {
 
    public Datos listaDatos;
    private static final String ruta = "../DataCredito/src/main/java/com/mycompany/datacredito/lista.txt";
  
    public Archivo() {
      
    }
   
    public Datos obtenerListasActuales() {
        listaDatos=new Datos();
       
        try {
            ObjectInputStream verDatos =  new ObjectInputStream(new FileInputStream(ruta));
            listaDatos = (Datos) verDatos.readObject();
  
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        return listaDatos;
    }

       public void guardarRegistro(Datos listaDatos) {
           
        try {
            ObjectOutputStream registro = new ObjectOutputStream(new FileOutputStream(ruta));
            registro.writeObject(listaDatos);
            registro.close();
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
       
}
