/*
    Descripción de la clase
*/

package co.edu.udea.surax.control;

import co.edu.udea.surax.modelo.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 * 
 */

public class Controlador {
    public static void main(String[] args) throws IOException {
        final String FILEVEHICULOS = "GuiaValoresVehiculos.csv";
        final String SEPARADORCSV  = ";";
        ArrayList<String> datosVehiculosCSV = new ArrayList<String>();
        datosVehiculosCSV = Utils.leerCsv(FILEVEHICULOS);
        
        ArrayList<VehiculoModelo> vehiculos = new ArrayList<VehiculoModelo>();
        
        for(String datosVehiculoCSV: datosVehiculosCSV) {
            String [] cutter = datosVehiculoCSV.split(SEPARADORCSV);
            String marca      = cutter[0];
            String clase      = cutter[1];
            String ref        = cutter[2];
            String servicio   = cutter[3];
            double valor      = Double.parseDouble(cutter[4]);
            boolean importado = Boolean.parseBoolean(cutter[5]);          
            int cilindraje    = Integer.parseInt(cutter[6]);
            int numPasajeros  = Integer.parseInt(cutter[7]);
            String tipoMotor  = cutter[8];           
            
            switch (clase) {
                case "AUTOMOVIL":
                    vehiculos.add(new CarroModelo(tipoMotor, cilindraje, clase, marca, ref, valor, servicio, numPasajeros, importado));
                    break;
                case "MOTOCICLETA":
                    vehiculos.add(new MotoModelo(tipoMotor, cilindraje, clase, marca, ref, valor, servicio, numPasajeros, importado));
                    break;
                case "CAMION":
                    vehiculos.add(new CamionModelo(cilindraje, clase, marca, ref, valor, servicio, numPasajeros, importado));
                    break;
                default:
                    break;
            }
            
        }
        
    }        
    
}