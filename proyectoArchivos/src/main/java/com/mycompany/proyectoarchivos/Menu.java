/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoarchivos;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author CamiloAlvarez
 */
public class Menu {
    Datos datos = new Datos();
    Scanner scan = new Scanner(System.in);
    Archivo archivo=new Archivo();

    public Menu() {
        
        datos=archivo.obtenerListasActuales();
        
    }

        

    public void MenuPersona(){
     int opcion = 0;
       
        do {
            System.out.print(" \n1. Agregar persona ");
            System.out.print(" \n2. Usar Persona");
            System.out.print(" \n3. Ver Persona");
            System.out.print(" \n4. Salir \n");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    try{
                    System.out.print("Ingrese cedula:");
                    int cc=scan.nextInt();
                    seleccionarPersona(cc);
                    }catch (ArithmeticException ex) {
                           ex.printStackTrace();
                           System.out.println("no es un numero");
                    } 
        
                    break;
                case 3:
                   verPersonas();
                    break;
        
            }

        } while (opcion != 4);
    }
    
    public void verPersonas(){
        
        for(Integer key:datos.getDataCredito().keySet()){
            System.out.print(" \nCedula:" + datos.getDataCredito().get(key).getDocumento());
            System.out.print(" \nNombre:" + datos.getDataCredito().get(key).getNombre());
 
        }
    }
    
    public void seleccionarPersona(int cc){
        
        if(datos.getDataCredito().containsKey(cc)){
            System.out.print("Persona encontrada");
            MenuReporte(cc);
        }else{
             System.out.print("Persona no encontrada");
        }
   
    }
    
    public void agregarPersona(){
        
        System.out.print("Ingrese cedula:");
        int cc=scan.nextInt();
        
        System.out.print("Ingrese el nombre:");
        String nombre=scan.next();
      
        Persona persona= new Persona(nombre,cc);
        datos.getDataCredito().put(cc,persona);
        
        archivo.guardarRegistro(datos);
        
       
    }


     public void MenuReporte(int cc){
     int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(" \n1. Agregar Reporte ");
            System.out.print(" \n2. Eliminar Reporte ");
             System.out.print(" \n3. Ver reporte");
               System.out.print(" \n4. Salir \n");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    AgregarReporte(cc);
                    break;
                case 2:
                    try{
                    System.out.print("Ingrese codigo:");
                    int codigo=scan.nextInt();
                    eliminarReporte(cc, codigo);
                    }catch(ArithmeticException ex){
                        System.out.println("no es un numero");
                    }
                    
                    break;
                case 3:
                    verReporte(cc);
                    break;
               
              
            }

        } while (opcion != 4);
    }
     
     public void AgregarReporte(int cc){
          
 
        System.out.print("Ingrese el codigo:");
        int cod=scan.nextInt();
        
                
        System.out.print("Ingrese el nombre:");
        String nombre=scan.next();
        
        
        System.out.print("Ingrese el estado:");
        boolean estado=scan.nextBoolean();
        
                       
        System.out.print("Ingrese la descripcion:");
        String descripcion=scan.next();
        
         System.out.print("Ingrese el valor:");
        double valor=scan.nextDouble();
       
        Reporte nuevoReporte=new Reporte(cod, nombre, estado, descripcion, valor);
       
        datos.getDataCredito().get(cc).getHistorial().put(cod, nuevoReporte);
        archivo.guardarRegistro(datos);
        
     }
     
      
    public void eliminarReporte(int cc,int cod){
        
        if( datos.getDataCredito().get(cc).getHistorial().containsKey(cod)){
            datos.getDataCredito().get(cc).getHistorial().remove(cod);
              System.out.print("Reporte eliminado");
              archivo.guardarRegistro(datos);
        }else{
             System.out.print("Reporte no encontrada");
        }
   
    }
    
     public void verReporte(int cc){
        for(Integer iterador: datos.getDataCredito().get(cc).getHistorial().keySet()){
            
            Reporte reporte= datos.getDataCredito().get(cc).getHistorial().get(iterador);
            System.out.print(" \nCodigo:" + reporte.getCodigo());
            System.out.print(" \nNombre:" + reporte.getNombre());
            System.out.print(" \nEstado:" + reporte.isEstado());
            System.out.print(" \nDescripcion:" + reporte.getDescripcion());
            System.out.print(" \nValor:" + reporte.getValor());
        
        }
    }
     
      
}
