/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.modelo;

import java.util.ArrayList;

/**
 *
 * @author Eljac
 */
public class PolizaParticular {
    
    NaturalModelo asegurado;
    ArrayList<RiesgoModelo> riesgos;

    public PolizaParticular(NaturalModelo asegurado) {
        this.asegurado = asegurado;
    }
    
    public PolizaParticular(NaturalModelo asegurado, ArrayList<RiesgoModelo> riesgos) {
        this.asegurado = asegurado;
        this.riesgos = riesgos;
    }
    
    void calcularRiesgos(){
        
    }
}
