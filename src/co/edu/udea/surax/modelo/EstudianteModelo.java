/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.modelo;

/**
 *
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 *
 */
public class EstudianteModelo extends NaturalModelo {

    String programa;
    String institucion;
    String tipoInstitucion;
    NaturalModelo acudiente;

    

    //Getters & Setters 
    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public NaturalModelo getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(NaturalModelo acudiente) {
        this.acudiente = acudiente;
    }

}
