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

public class PersonaModelo {
    
    private String name;
    private Integer id;
    private Integer age;
    private Integer tel;

    public PersonaModelo(String name, Integer id, Integer age, Integer tel) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.tel = tel;
    }
    
    public PersonaModelo(){
        
    }

}
