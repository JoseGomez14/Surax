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
public class RiesgoModelo {
    
    private String nombre;
    private double valorBase;
    private double valorMensual;

    public RiesgoModelo(String nombre, int valorBase, int valorMensual) {
        this.nombre = nombre;
        this.valorBase = valorBase;
        this.valorMensual = valorMensual;
    }

    //Setter & Getter
    public String getNombre() {
        return nombre;
    }
    public double getValorBase() {
        return valorBase;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public void setValorMensual(double valorMensual) {
        this.valorMensual = valorMensual;
    }
    
    

    //Métodos
    
    /**
     * Metodo que multiplica el valor base por un porcentaje con el fin de cambiar el valor base y mensual de la poliza
     * 
     * @param porcentaje 
     */
    void calcularValores(short porcentaje, short porcentaje2){
        
        this.valorBase *= porcentaje;
        this.valorMensual *= porcentaje2;
        
    }
    
    
}
