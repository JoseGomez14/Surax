/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.modelo;

/**
 *
 * @author Eljac
 */
public class EstudianteModelo extends NaturalModelo{
    
    String programa;
    String institucion;
    String tipoInstitucion;
    NaturalModelo acudiente;

    public EstudianteModelo(String programa, String institucion, String tipoInstitucion, NaturalModelo acudiente) {
        this.programa = programa;
        this.institucion = institucion;
        this.tipoInstitucion = tipoInstitucion;
        this.acudiente = acudiente;
    }

    public EstudianteModelo(String programa, String institucion, String tipoInstitucion, NaturalModelo acudiente, char sexo, String enfermedadesPreinscritas, String discapacidad, String ocupacion, short estrato, boolean estadoCivil, String nivelEducativo, short edad) {
        super(sexo, enfermedadesPreinscritas, discapacidad, ocupacion, estrato, estadoCivil, nivelEducativo, edad);
        this.programa = programa;
        this.institucion = institucion;
        this.tipoInstitucion = tipoInstitucion;
        this.acudiente = acudiente;
    }

    public EstudianteModelo(String programa, String institucion, String tipoInstitucion, NaturalModelo acudiente, String nombre, int id, int tel, String correo) {
        super(nombre, id, tel, correo);
        this.programa = programa;
        this.institucion = institucion;
        this.tipoInstitucion = tipoInstitucion;
        this.acudiente = acudiente;
    }
    
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
