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
public class NaturalModelo extends PersonaModelo {

    private char sexo;
    private String enfermedadesPreinscritas;
    private boolean discapacidad;

    //riesgo de la ocupación del 1 al 10
    private short ocupacion;
    private short estrato;
    private boolean estadoCivil;
    private String nivelEducativo;
    private short edad;
    private short peso;
    private short altura;
    private short vo2max;
    private int porcRiesgo;

    //Constructores
    public NaturalModelo() {
    }

    public NaturalModelo(char sexo, String enfermedadesPreinscritas,
            boolean discapacidad, short ocupacion, short estrato,
            boolean estadoCivil, String nivelEducativo, short edad,
            short peso, short altura, short vo2max) {

        this.sexo = sexo;
        this.enfermedadesPreinscritas = enfermedadesPreinscritas;
        this.discapacidad = discapacidad;
        this.ocupacion = ocupacion;
        this.estrato = estrato;
        this.estadoCivil = estadoCivil;
        this.nivelEducativo = nivelEducativo;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.vo2max = vo2max;
        calcularPorcRiesgo();
    }

    public NaturalModelo(String nombre, int id, int tel, String correo) {
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

    public boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public short getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(short ocupacion) {
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

    public int getPorcRiesgo() {
        return porcRiesgo;
    }

    public void setPorcRiesgo(int porcRiesgo) {
        this.porcRiesgo = porcRiesgo;
    }

    //Metodo
    public void calcularPorcRiesgo() {

        double imc = getPeso() / (getAltura() * getAltura());
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
        if (imc < 18) {
            puntaje += 3;
        } else if (imc >= 25 && imc <= 29.9) {
            puntaje += 5;
        } else if (imc > 30) {
            puntaje += 8;
        }
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
        if (getVo2max() < 35) {
            puntaje += 5;
        }
        if (getEnfermedadesPreinscritas().equalsIgnoreCase("Paciente terminal")) {
            puntaje += 50;
        }
        if (getSexo() == 'M') {
            puntaje += 5;
        }

        if (getDiscapacidad()) {
            puntaje += 3;
        }
        
        Double res = ((Math.exp(edad/20.268888)- 1.6666)) ;
        puntaje = res.intValue();
        
        if (puntaje >= 50) {
            setPorcRiesgo(100);
        } else {
            setPorcRiesgo(puntaje * 2);
        }
        
    }

}
