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

public class VehiculoModelo {
    // Declaración de propiedades de la clase vehículo
    private String clase;
    private String marca;
    private int modelo;
    private String ref;
    private String placa;
    private double valor;
    private PersonaModelo propietario;
    private int kmRecorridos;
    private String color;
    private String servicio; // Publico o particular
    private int numPasajeros;
    private boolean importado;
    
    //Método constructor
    public VehiculoModelo() {
    }
    
    //Método constructor base
    public VehiculoModelo(String clase, String marca, String ref, double valor, String servicio, int numPasajeros, boolean importado) {        
        this.clase = clase;
        this.marca = marca;
        this.ref = ref;
        this.valor = valor;
        this.servicio = servicio;
        this.numPasajeros = numPasajeros;
        this.importado = importado;
    }

    //Método constructor con todos los atributos exepto el valor
    public VehiculoModelo(String clase, String marca, String estado, int modelo, String ref, String placa, PersonaModelo dueño, int kmRecorridos, String color, String servicio, int numPasajeros, boolean importado) {
        this.clase = clase;
        this.marca = marca;
        this.modelo = modelo;
        this.ref = ref;
        this.placa = placa;
        this.propietario = dueño;
        this.kmRecorridos = kmRecorridos;
        this.color = color;
        this.servicio = servicio;
        this.numPasajeros = numPasajeros;
        this.importado = importado;
    }
    
    //Getters y setters para todas las variables
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public PersonaModelo getPropietario() {
        return propietario;
    }

    public void setPropietario(PersonaModelo propietario) {
        this.propietario = propietario;
    }

    public int getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(int kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    public boolean getImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }
        
    //Métodos  de la clase
    public double calcValorComercial(String clase, String marca, int modelo, String ref, String servicio){
        double valor = 0;
        return valor;
    }
    
}
