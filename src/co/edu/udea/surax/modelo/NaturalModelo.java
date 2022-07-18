/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 *
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 *
 */
public class NaturalModelo extends PersonaModelo {

    private char sexo;
    private String enfermedadesPreinscritas;
    private boolean discapacidad;
    private short estrato;
    private String estadoCivil;
    private String nivelEducativo;
    
    //Nombre de la ocupacion, valor de riesgo asociado
    private HashMap<String, Integer> ocupacion;
    private ArrayList<HashMap> trabajos;
    private short edad;
    /*private short peso;
    private short altura;
    private short vo2max;*/
    private int porcRiesgo;

    //Constructores

    public NaturalModelo(){
        
    }

    public NaturalModelo(char sexo, String enfermedadesPreinscritas, boolean 
            discapacidad, String ocupacion, short estrato, String estadoCivil, 
            String nivelEducativo, short edad, String nombre, 
            long id, long tel, ArrayList<String> direccion, String correo) throws IOException {
        super(nombre, id, tel, direccion, correo);
        this.trabajos = Utils.leerCsv("Profesiones.csv",0);
        this.sexo = sexo;
        this.enfermedadesPreinscritas = enfermedadesPreinscritas;
        this.discapacidad = discapacidad;
        this.estrato = estrato;
        this.estadoCivil = estadoCivil;
        this.nivelEducativo = nivelEducativo;
        this.edad = edad;
        asignarOcupacion(ocupacion);
        calcularPorcRiesgo();
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

    public boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getOcupacion() {
        return String.valueOf(this.ocupacion.get(0));
    }

    public void setOcupacion(HashMap ocupacion) {
        this.ocupacion = ocupacion;
    }

    public short getEstrato() {
        return estrato;
    }

    public void setEstrato(short estrato) {
        this.estrato = estrato;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
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
    
    
/*
    public short getPeso() {
        return peso;
    }

    public void setPeso(short peso) {
        this.peso = peso;
    }

    public short getAltura() {
        return altura;
    }

    public void setAltura(short altura) {
        this.altura = altura;
    }

    public short getVo2max() {
        return vo2max;
    }

    public void setVo2max(short vo2max) {
        this.vo2max = vo2max;
    }
*/
    public int getPorcRiesgo() {
        return porcRiesgo;
    }
    
    //Metodo
    public final void calcularPorcRiesgo() {

       // double imc = getPeso() / (getAltura() * getAltura());
        int puntaje = 0;

        //Filtramos las enfermedades para el puntaje
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Diabetes I")) {
            puntaje += 10;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Diabetes II")) {
            puntaje += 4;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Enfermedad leve")) {
            puntaje += 1;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Enfermedad grave")) {
            puntaje += 20;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Enfermedad medianamente grave")) {
            puntaje += 8;
        }
       /* if (imc < 18) {
            puntaje += 3;
        } else if (imc >= 25 && imc <= 29.9) {
            puntaje += 5;
        } else if (imc > 30) {
            puntaje += 8;
        }*/
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Cardiopatía isquémica")) {
            puntaje += 20;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Demencia")) {
            puntaje += 18;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Antecedente cerebrovacular")) {
            puntaje += 20;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Enfermedad pulmonar")) {
            puntaje += 18;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Cáncer de pulmón")) {
            puntaje += 20;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Hipertensión")) {
            puntaje += 10;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Cancer de colon")) {
            puntaje += 18;
        }
       /* if (getVo2max() < 35) {
            puntaje += 5;
        }*/
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Paciente terminal")) {
            puntaje += 50;
        }
        if (getSexo() == 'M') {
            puntaje += 5;
        }

        if (getDiscapacidad()) {
            puntaje += 3;
        }
        
        String n = String.valueOf(this.ocupacion.get(1));
        puntaje += (Integer.parseInt(n)*2);
        
        Double res = ((Math.exp(edad/20.268888)- 1.6666)) ;
        puntaje = res.intValue();
        
        if (puntaje >= 50) {
            this.porcRiesgo = 100;
        } else {
            this.porcRiesgo = puntaje * 2;
        }
        
     
    }

    
    /**
     * Método que asigna el empleo seleccionado a la persona
     * 
     * @param empleo el trabajo que haya seleccionado el usuario
     */
    public void asignarOcupacion(String empleo) {
        this.trabajos.stream().filter((trabajo) -> (trabajo.get(0).equals(empleo))).forEachOrdered((HashMap trabajo) -> {
            NaturalModelo.this.ocupacion = trabajo;
        });
    }

}
