/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.control;

import co.edu.udea.surax.modelo.PolizaVidaModelo;
import co.edu.udea.surax.modelo.RiesgoModelo;
import java.util.ArrayList;

/**
 *
 * @author Eljac
 */
public class PolizaVidaControl implements PolizaInterface {

    private ArrayList<RiesgoModelo> Riesgos = new ArrayList<>();
    private ArrayList<PolizaVidaModelo> Polizas;

    public PolizaVidaControl() {
        llenarRiesgos();
    }
    
    /**
     * 
     * Llena los riesgos posibles que puede cubrir una póliza de vida
     * 
     */
    @Override
    public final void llenarRiesgos() {
      
        RiesgoModelo muerte;
        muerte = new RiesgoModelo("Muerte", 100000000, 500000);
        RiesgoModelo accidental;
        accidental = new RiesgoModelo("Muerte accidental", 200000000, 300000);
        RiesgoModelo invalidez;
        invalidez = new RiesgoModelo("Invalidez o desmembración permanente", 20000000, 100000);
        RiesgoModelo curacion;
        curacion = new RiesgoModelo("Gastos de curación por accidente", 5000000, 100000);
        RiesgoModelo cancer;
        cancer = new RiesgoModelo("Cáncer", 40000000, 250000);
        RiesgoModelo enfermedadesGraves;
        enfermedadesGraves = new RiesgoModelo("graves", 60000000, 350000);
        RiesgoModelo exequias;
        exequias = new RiesgoModelo("Exequias", 10000000, 100000);
        
        this.Riesgos.add(muerte);
        this.Riesgos.add(accidental);
        this.Riesgos.add(invalidez);
        this.Riesgos.add(curacion);
        this.Riesgos.add(cancer);
        this.Riesgos.add(enfermedadesGraves);
        this.Riesgos.add(exequias);
    }

    @Override
    public void agregarPoliza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarPoliza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarPoliza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarPoliza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
