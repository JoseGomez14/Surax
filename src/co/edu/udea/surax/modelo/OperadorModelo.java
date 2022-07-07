/*
    Descripción de la clase
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

public class OperadorModelo extends PersonaModelo{
    private String cargo;
    private double tiempoDeTrabajo; //En meses
    private int numVentas;

    public OperadorModelo() {
    }

    public OperadorModelo(String cargo, double tiempoDeTrabajo, int numVentas, String nombre, int id, int tel, ArrayList<String> direccion, String correo) {
        super(nombre, id, tel, direccion, correo);
        this.cargo = cargo;
        this.tiempoDeTrabajo = tiempoDeTrabajo;
        this.numVentas = numVentas;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getTiempoDeTrabajo() {
        return tiempoDeTrabajo;
    }

    public void setTiempoDeTrabajo(double tiempoDeTrabajo) {
        this.tiempoDeTrabajo = tiempoDeTrabajo;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }
    
}