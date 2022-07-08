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

public class CarroModelo extends VehiculoModelo{
    private String tipoMotor; //Electrico o combustión
    private int cilindraje;
    
    //Método constructor
    public CarroModelo() {
    }
    
    //Método constructor con todos los atributos exepto el valor
    public CarroModelo(String tipoMotor, int cilindraje, String clase, String marca, String estado, int modelo, String ref, String placa, PersonaModelo propietario, int kmRecorridos, String color, String servicio, int numPasajeros) {        
        super(clase, marca, estado, modelo, ref, placa, propietario, kmRecorridos, color, servicio, numPasajeros);
        this.tipoMotor = tipoMotor;
        this.cilindraje = cilindraje;
    }

    //Getters y setters para todas las variables
    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcValorComercial(String clase, String marca, int modelo, String ref, String servicio) {
        return super.calcValorComercial(clase, marca, modelo, ref, servicio); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}