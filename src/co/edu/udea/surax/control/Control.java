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

    public static void main(String[] args) throws IOException{
        ArrayList<PersonaModelo> listaDePersonas = new ArrayList<PersonaModelo>();
        ArrayList<VehiculoModelo> listaDeVehiculos = new ArrayList<VehiculoModelo>();
        ArrayList<EstudianteModelo> listaDeEstudiantes = new ArrayList<EstudianteModelo>();
        ArrayList<PolizaVidaModelo> listaPolizasPersonas = new ArrayList<PolizaVidaModelo>();
        ArrayList<Object> data = new ArrayList<>();
        
        data.add(listaDePersonas);
        data.add(listaDeVehiculos);
        data.add(listaDeEstudiantes);
        data.add(listaPolizasPersonas);
        
        ArrayList<String> direccionOperario = new ArrayList<>();
        direccionOperario.add("Colombia");
        direccionOperario.add("Antioquia");
        direccionOperario.add("Antioquia");
        direccionOperario.add("Andes");
        direccionOperario.add("");
        
        data.add(new OperarioModelo("Vendedor", 10, 30, "Juan Peréz", 1040402343, 6488080, direccionOperario, "juan.perez@gmail.com"));
        Surax ventanaIncial = new Surax(data);
        ventanaIncial.setVisible(true);
    }   
    
}
