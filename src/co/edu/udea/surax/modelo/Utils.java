/*
    Descripción de la clase
*/

package co.edu.udea.surax.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 * 
 */

public class Utils {

    public Utils() {
    }
    
    /**
     * Método que permite leer información de un archivo .csv
     * @param filePath es la ruta del archivo que se desea leer
     */
    public static ArrayList<String> leerCsv(String filePath) throws IOException {
        BufferedReader br = null;
        FileReader fr = null;
        ArrayList<String> result = new ArrayList<String>();

        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (null != line) {
                result.add(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (null != br) {
                br.close();
            }
        }
        return result;
    }
}
