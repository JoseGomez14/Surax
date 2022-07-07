package co.edu.udea.surax.modelo;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 *
 */
public class PolizaModelo {
    
    int idPoliza;
    double costo;
    Date fechaExp;
    //operario vendedor
    String tipo;
    int mesesContratados;
    Date vigencia;
    PersonaModelo tomador;
    PersonaModelo beneficiario;
    short porcDescuento;
    String [] Beneficios;
    
}
