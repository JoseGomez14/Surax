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
public class PersonaModelo {

    private String nombre;
    private int id;
    private int tel;
    // En 0 país, en 1 departamento, en 2 municipio, en 3 zona (Rural, Urbano), en 4 direccion, en 5 código postal 
    private ArrayList<String> direccion;
    private String correo;

    public PersonaModelo() {

    }

    //Constructores
    public PersonaModelo(String nombre, int id, int tel, ArrayList<String> direccion, String correo) {
        this.nombre = nombre;
        this.id = id;
        this.tel = tel;
        this.direccion = direccion;
        this.correo = correo;
    }

    //Setters & Getters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public ArrayList<String> getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList<String> direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
}
