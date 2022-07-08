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
public class OperarioModelo extends PersonaModelo{
    private String cargo;
    private int mesesTrabajo;
    private int numVentas;
    
    //Métodos constructores
    public OperarioModelo() {
    }

    public OperarioModelo(String nombre, int id, int tel, ArrayList<String> direccion, String correo) {
        super(nombre, id, tel, direccion, correo);
    }
    
    public OperarioModelo(String cargo, int mesesTrabajo, int numVentas) {
        this.cargo = cargo;
        this.mesesTrabajo = mesesTrabajo;
        this.numVentas = numVentas;
    }

    public OperarioModelo(String cargo, int mesesTrabajo, int numVentas, String nombre, int id, int tel, ArrayList<String> direccion, String correo) {
        super(nombre, id, tel, direccion, correo);
        this.cargo = cargo;
        this.mesesTrabajo = mesesTrabajo;
        this.numVentas = numVentas;
    }
    
    //Getters and Setters para todas las variables
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getMesesTrabajo() {
        return mesesTrabajo;
    }

    public void setMesesTrabajo(int mesesTrabajo) {
        this.mesesTrabajo = mesesTrabajo;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }
    
}
