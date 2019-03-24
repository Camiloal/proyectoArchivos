/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoarchivos;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author CamiloAlvarez
 */
public class Persona {
    
    private String nombre;
    private int documento;
    private HashMap<Integer, Reporte> historial ;

    public Persona(String nombre, int documento) {
        this.nombre = nombre;
        this.documento = documento;
     
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public HashMap<Integer, Reporte> getHistorial() {
        return historial;
    }

    public void setHistorial(HashMap<Integer, Reporte> historial) {
        this.historial = historial;
    }
    
    
    
    
    
}
