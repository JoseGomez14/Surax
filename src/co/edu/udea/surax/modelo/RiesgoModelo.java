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
    private int valorBase;
    private int valorMensual;

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

    public int getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valorBase) {
        this.valorBase = valorBase;
    }

    public int getValorMensual() {
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
