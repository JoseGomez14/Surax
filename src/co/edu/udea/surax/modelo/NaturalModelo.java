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
public class NaturalModelo extends PersonaModelo{
    
    private char sexo;
    private String enfermedadesPreinscritas;
    private String discapacidad;
    private String ocupacion;
    private short estrato;
    private boolean estadoCivil;
    private String nivelEducativo;
    private short edad;

    
    //Constructores
    public NaturalModelo() {
    }

    public NaturalModelo(char sexo, String enfermedadesPreinscritas, String discapacidad, String ocupacion, short estrato, boolean estadoCivil, String nivelEducativo, short edad) {
        this.sexo = sexo;
        this.enfermedadesPreinscritas = enfermedadesPreinscritas;
        this.discapacidad = discapacidad;
        this.ocupacion = ocupacion;
        this.estrato = estrato;
        this.estadoCivil = estadoCivil;
        this.nivelEducativo = nivelEducativo;
        this.edad = edad;
    }
    
    public NaturalModelo(String nombre, int id, int tel, String correo){
        super.setNombre(nombre);
        super.setId(id); 
        super.setTel(tel);
        super.setCorreo(correo);
    }
    
    //Getters & Setters

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEnfermedadesPreinscritas() {
        return enfermedadesPreinscritas;
    }

    public void setEnfermedadesPreinscritas(String enfermedadesPreinscritas) {
        this.enfermedadesPreinscritas = enfermedadesPreinscritas;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public short getEstrato() {
        return estrato;
    }

    public void setEstrato(short estrato) {
        this.estrato = estrato;
    }

    public boolean isEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(boolean estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }
    
}
