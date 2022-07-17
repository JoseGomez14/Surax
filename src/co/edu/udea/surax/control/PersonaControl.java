/*
    Descripción de la clase
*/

package co.edu.udea.surax.control;

import co.edu.udea.surax.modelo.PersonaModelo;
import co.edu.udea.surax.modelo.NaturalModelo;
import co.edu.udea.surax.modelo.JuridicaModelo;
import java.util.ArrayList;

/**
 * 
 * @author Jose D. Gómez M.
 * @author Hector A. Güiza O
 * @author Luis D. Martínez G.
 * 
 */
 
public class PersonaControl{
    
    public static ArrayList<PersonaModelo> listaDePersonas = new ArrayList<PersonaModelo>();
    
    /**
     * Este método permite agregar una <b>persona natural</b> a la lista de personas.
     * 
     * @param nombre
     * @param id
     * @param tel
     * @param direccion
     * @param correo
     * @param sexo
     * @param enfermedadesPreinscritas
     * @param discapacidad
     * @param ocupacion
     * @param estrato
     * @param estadoCivil
     * @param nivelEducativo
     * @param edad
     * @param peso
     * @param altura
     * @param vo2max 
     */
    public void crearPersona(String nombre, int id, int tel, ArrayList<String> direccion, 
            String correo, char sexo, String enfermedadesPreinscritas, boolean discapacidad, short ocupacion,
            short estrato, boolean estadoCivil, String nivelEducativo, short edad, short peso,  short altura,
            short vo2max){
        listaDePersonas.add(new NaturalModelo(ocupacion, edad, nombre, id, tel, direccion, correo));
    }
    
    /**
     * Este método permite agregar una <b>persona Jurídica</b> a la lista de personas.
     * 
     * @param nombre
     * @param id
     * @param tel
     * @param direccion
     * @param correo
     * @param actividadPrincipal
     * @param sector 
     */
    public void crearPersona(String nombre, int id, int tel, ArrayList<String> direccion, 
            String correo, String actividadPrincipal, String sector){
        listaDePersonas.add(new JuridicaModelo(nombre, id, tel, direccion, correo));
    }
    
    /**
     * Este método permite leer la información de una persona pasandole como parametro su <b>número
     * de identificación</b> en el caso de las <b>personas naturales</b> y el <b>NIT</b> en el caso
     * de las <b>personas jurídicas</b>, el método devolvera el objeto siempre que este se encuentre
     * resgistrado en la lista.
     * 
     * @param id número que identifica a la persona que se desea leer.
     * @return 
     */
    public PersonaModelo leerPersona(int id){
        PersonaModelo result = null;
        if(!listaDePersonas.isEmpty()){
            for(PersonaModelo persona: listaDePersonas){
                if(persona.getId() == id){
                    return persona;
                }
            
            }
        }
        return result;   
    }
    
    /**
     * Este método permite actualizar la información de una persona natural de 
     * la lista.
     * 
     * @param nombre
     * @param id
     * @param tel
     * @param direccion
     * @param correo
     * @param sexo
     * @param enfermedadesPreinscritas
     * @param discapacidad
     * @param ocupacion
     * @param estrato
     * @param estadoCivil
     * @param nivelEducativo
     * @param edad
     * @param peso
     * @param altura
     * @param vo2max
     * 
     * @return retorna un boolean de acuerdo al estado de la operación
     */
    public boolean actPersona(String nombre, int id, int tel, ArrayList<String> direccion, 
        String correo, char sexo, String enfermedadesPreinscritas, boolean discapacidad, short ocupacion,
        short estrato, boolean estadoCivil, String nivelEducativo, short edad, short peso,  short altura,
        short vo2max){
        
        if(!listaDePersonas.isEmpty()){
            for(int i = 0; i < listaDePersonas.size(); i++){
                if(listaDePersonas.get(i).getId() == id){
                    listaDePersonas.set(i , new NaturalModelo(nombre, id, tel, correo));
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    /**
     * Este método permite actualizar la información de una persona jurídica de 
     * la lista. 
     * 
     * @param nombre
     * @param id
     * @param tel
     * @param direccion
     * @param correo
     * @param actividadPrincipal
     * @param sector 
     * 
     * @return 
     */
    public boolean actPersona(String nombre, int id, int tel,ArrayList<String> direccion, 
            String correo, String actividadPrincipal, String sector){
        
        if(!listaDePersonas.isEmpty()){
            for(int i = 0; i < listaDePersonas.size(); i++){
                if(listaDePersonas.get(i).getId() == id){
                    listaDePersonas.set(i , new JuridicaModelo(nombre, id, tel, direccion, correo));
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Este método permite eliminar una objeto de tipo persona de la lista
     * pasando el parametro del <b>id</b> o el <b>NIT</b> de la persona que se
     * desea eliminar segúnn corresponda a <b>persona natural</b> o 
     * <b>persona jurídica</b> respectivamente.
     * 
     * @param id número que identifica a la persona que se desea eliminar.
     * @return retorna el estado de la acción.
     */
    public boolean eliminarPersona(int id){
        if(!listaDePersonas.isEmpty()){
            for(PersonaModelo persona: listaDePersonas){
                if(persona.getId() == id){
                    listaDePersonas.remove(persona);
                    return true;
                } 
            }              
        }
        return false;
    }
}