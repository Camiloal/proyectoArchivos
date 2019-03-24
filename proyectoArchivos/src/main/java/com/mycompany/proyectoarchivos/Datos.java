/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoarchivos;

import java.util.HashMap;

/**
 *
 * @author CamiloAlvarez
 */
public class Datos {
    private HashMap<Integer, Persona> dataCredito =new HashMap<>();

    public HashMap<Integer, Persona> getDataCredito() {
        return dataCredito;
    }

    public void setDataCredito(HashMap<Integer, Persona> dataCredito) {
        this.dataCredito = dataCredito;
    }
    
    
    
}
