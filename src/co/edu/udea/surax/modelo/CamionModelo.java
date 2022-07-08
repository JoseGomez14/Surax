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

public class CamionModelo extends VehiculoModelo{
    private int ejes;
    private String proposito;
    private int cilindraje;
    
    //Método constructor
    public CamionModelo() {
    }
        
    //Método constructor con todos los atributos exepto el valor
    public CamionModelo(int ejes, String proposito, int cilindraje, String clase, String marca, String estado, int modelo, String ref, String placa, PersonaModelo dueño, int kmRecorridos, String color, String servicio, int numPasajeros) {
        super(clase, marca, estado, modelo, ref, placa, dueño, kmRecorridos, color, servicio, numPasajeros);
        this.ejes = ejes;
        this.proposito = proposito;
        this.cilindraje = cilindraje;
    }

    //Getters y setters para todas las variables
    public int getEjes() {
        return ejes;
    }

    public void setEjes(int ejes) {
        this.ejes = ejes;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
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