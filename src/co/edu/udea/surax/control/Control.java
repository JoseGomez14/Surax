/*
    Descripción de la clase
*/

package co.edu.udea.surax.control;

import co.edu.udea.surax.modelo.*;
import co.edu.udea.surax.vista.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 * 
 */

public class Control {

    public static void main(String[] args) throws IOException {
        Surax ventanaIncial = new Surax();
        ventanaIncial.setVisible(true);

        ArrayList<PersonaModelo> listaDePersonas;
        ArrayList<VehiculoModelo> listaDeVehiculos;
        ArrayList<EstudianteModelo> listaEstudiantes;

        /*ArrayList<HashMap> aiuda = new ArrayList<>();
        aiuda = Utils.leerCsv("Profesiones.csv", 0);

        for (HashMap aiuda1 : aiuda) {
            System.out.println(aiuda1.get(0) + String.valueOf(aiuda1.get(1)));
        }*/
    }

}
