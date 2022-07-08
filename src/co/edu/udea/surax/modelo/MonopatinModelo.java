/*
    Descripción de la clase
*/

package co.edu.udea.surax.modelo;

/**
 * 
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 * 
 */
public class MonopatinModelo extends VehiculoModelo{
    private String proposito;
    private String tipoMarco;
    private boolean motor;
    private String tipoMotor;
    
    //Método constructor
    public MonopatinModelo() {
    }
    
    //Método constructor con todos los atributos exepto el valor
    public MonopatinModelo(String proposito, String tipoMarco, boolean motor, String tipoMotor, String clase, String marca, String estado, int modelo, String ref, String placa, PersonaModelo propietario, int kmRecorridos, String color, String servicio, int numPasajeros) {
        super(clase, marca, estado, modelo, ref, placa, propietario, kmRecorridos, color, servicio, numPasajeros);
        this.proposito = proposito;
        this.tipoMarco = tipoMarco;
        this.motor = motor;
        this.tipoMotor = tipoMotor;
    }
    
    //Getters and Setters para todas las variables
    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getTipoMarco() {
        return tipoMarco;
    }

    public void setTipoMarco(String tipoMarco) {
        this.tipoMarco = tipoMarco;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public double calcValorComercial(String clase, String marca, int modelo, String ref, String servicio) {
        return super.calcValorComercial(clase, marca, modelo, ref, servicio); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}