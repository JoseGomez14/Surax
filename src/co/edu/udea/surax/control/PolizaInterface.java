/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.control;

import java.util.ArrayList;
import co.edu.udea.surax.modelo.RiesgoModelo;
import co.edu.udea.surax.control.PersonaControl;
/**
 *
 * @author Eljac
 */
public interface PolizaInterface {


    void llenarRiesgos();
    void agregarPoliza();
    void buscarPoliza();
    void actualizarPoliza();
    void borrarPoliza();
}
