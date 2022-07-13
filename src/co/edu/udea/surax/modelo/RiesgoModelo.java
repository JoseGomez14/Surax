/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.modelo;

/**
 *
 * @author Eljac
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valorBase) {
        this.valorBase = valorBase;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public void setValorMensual(int valorMensual) {
        this.valorMensual = valorMensual;
    }

    //Métodos
    
    void calcularValores(short porcentaje){
        
        this.valorBase *= porcentaje;
        this.valorMensual *= porcentaje;
        
    }
    
    
}
