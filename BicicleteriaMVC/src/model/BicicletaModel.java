/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Luis
 */
public class BicicletaModel {
    // ### Atributos ###
    private int     identificador;
    private String  referencia;
    private double  costo;
    
    /**
     * Constructor para manejo de la tabla
     * @param identificador
     * @param referencia
     * @param costo 
     */
    public BicicletaModel(int identificador, String referencia, double costo){
        this.identificador  = identificador;
        this.referencia     = referencia;
        this.costo          = costo;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public Object[] toArray(){
        Object[] data = {identificador, referencia, costo};
        return data;
    }
    
    public String toString(){
        return referencia;
    }
}
