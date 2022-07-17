/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.modelo;

import java.util.ArrayList;

/**
 *
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 *
 */
public class JuridicaModelo extends PersonaModelo{
    
    //La razón social se guarda en la variable "nombre" de la clase padre
    
    private String actividadPrincipal;
    private String sector;

    public JuridicaModelo(String actividadPrincipal, String sector) {
        this.actividadPrincipal = actividadPrincipal;
        this.sector = sector;
    }

    public JuridicaModelo(String actividadPrincipal, String sector, 
            String nombre, long  id, long tel, ArrayList<String> direccion, String correo) {
        super(nombre, id, tel, direccion, correo);
        this.actividadPrincipal = actividadPrincipal;
        this.sector = sector;
    }

    //Setters & Getters
    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
}
