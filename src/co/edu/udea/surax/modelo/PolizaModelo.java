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

    private int idPoliza;
    private double costo;
    private Date fechaExp;
    private OperadorModelo vendedor;
    private String tipo;
    private int mesesContratados;
    private Date vigencia;
    private PersonaModelo tomador;
    private PersonaModelo beneficiario;
    private short porcDescuento;
    private String[] Beneficios;
    private boolean activo;
    private double valor;

    public PolizaModelo(int idPoliza, double costo, Date fechaExp,
            OperadorModelo vendedor, String tipo, int mesesContratados,
            Date vigencia, PersonaModelo tomador, PersonaModelo beneficiario,
            short porcDescuento, String[] Beneficios) {
        this.idPoliza = idPoliza;
        this.costo = costo;
        this.fechaExp = fechaExp;
        this.vendedor = vendedor;
        this.tipo = tipo;
        this.mesesContratados = mesesContratados;
        this.vigencia = vigencia;
        this.tomador = tomador;
        this.beneficiario = beneficiario;
        this.porcDescuento = porcDescuento;
        this.Beneficios = Beneficios;

    }

    public PolizaModelo() {
    }

    //Setter & Getter
    public int getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(int idPoliza) {
        this.idPoliza = idPoliza;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(Date fechaExp) {
        this.fechaExp = fechaExp;
    }

    public OperadorModelo getVendedor() {
        return vendedor;
    }

    public void setVendedor(OperadorModelo vendedor) {
        this.vendedor = vendedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMesesContratados() {
        return mesesContratados;
    }

    public void setMesesContratados(int mesesContratados) {
        this.mesesContratados = mesesContratados;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public PersonaModelo getTomador() {
        return tomador;
    }

    public void setTomador(PersonaModelo tomador) {
        this.tomador = tomador;
    }

    public PersonaModelo getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(PersonaModelo beneficiario) {
        this.beneficiario = beneficiario;
    }

    public short getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(short porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public String[] getBeneficios() {
        return Beneficios;
    }

    public void setBeneficios(String[] Beneficios) {
        this.Beneficios = Beneficios;
    }

}
