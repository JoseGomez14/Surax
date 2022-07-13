/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.surax.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Eljac
 */
public class PolizaParticular extends PolizaModelo{

    NaturalModelo asegurado;
    ArrayList<RiesgoModelo> riesgos;

    public PolizaParticular(NaturalModelo asegurado) {
        this.asegurado = asegurado;
    }

    public PolizaParticular(NaturalModelo asegurado, ArrayList<RiesgoModelo> riesgos,
            int idPoliza, double costo, Date fechaExp,
            OperarioModelo vendedor, String tipo, int mesesContratados,
            Date vigencia, PersonaModelo tomador, PersonaModelo beneficiario,
            short porcDescuento, String Beneficios) {
        super(idPoliza, costo, fechaExp, vendedor, tipo, mesesContratados,
                vigencia, tomador, beneficiario, porcDescuento, Beneficios);

        this.asegurado = asegurado;
        this.riesgos = riesgos;
    }

    //Metodos
    void calcularRiesgos(String principal) {

        if (asegurado.getPorcRiesgo() > 80) {
            super.setValor(null);
            return;
        }

        for (RiesgoModelo riesgo : riesgos) {
            //Si se trata de la cobertura principal, se tienen en cuenta diferentes cosas
            riesgo.setValorBase(riesgo.getValorBase() + riesgo.getValorBase() * (((asegurado.getPorcRiesgo()) / 100) * ((asegurado.getPorcRiesgo()) / 100)));
            riesgo.setValorMensual(riesgo.getValorMensual() + riesgo.getValorMensual() * (((asegurado.getPorcRiesgo()) / 100) * ((asegurado.getPorcRiesgo()) / 100)));
        }
    }
}
