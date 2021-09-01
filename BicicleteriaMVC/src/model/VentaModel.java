/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
/**
 *
 * @author Luis
 */
public class VentaModel {
    // ### Atributos ###
    private int identificador;
    private int IdCliente_fk;
    private String fecha;
    private int IdBicicleta_fk;
    
    private String RefBicicleta;
    private double CostBicicleta;
    private String NombreCliente;
    
    
    /**
     * Constructor para manejo de la tabla
     * @param identificador
     * @param IdCliente_fk
     * @param fecha
     * @param IdBicicleta_fk 
     */
    public VentaModel(int identificador, int IdCliente_fk, 
            String fecha, int IdBicicleta_fk){
        this.identificador  = identificador;
        this.IdCliente_fk   = IdCliente_fk;
        this.fecha          = fecha;
        this.IdBicicleta_fk = IdBicicleta_fk;
    }
    
    public VentaModel( int IdCliente_fk, String fecha, int IdBicicleta_fk){
        this.IdCliente_fk   = IdCliente_fk;
        this.fecha          = fecha;
        this.IdBicicleta_fk = IdBicicleta_fk;
    }
    
    public VentaModel(String NombreCliente, String RefBicicleta, 
             String fecha, double CostBicicleta){
        
        this.fecha          = fecha;
        
        this.NombreCliente  = NombreCliente;
        this.RefBicicleta   = RefBicicleta;
        this.CostBicicleta  = CostBicicleta;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @return the IdCliente_fk
     */
    public int getIdCliente_fk() {
        return IdCliente_fk;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the IdBicicleta_fk
     */
    public int getIdBicicleta_fk() {
        return IdBicicleta_fk;
    }

    /**
     * @return the RefBicicleta
     */
    public String getRefBicicleta() {
        return RefBicicleta;
    }

    /**
     * @return the CostBicicleta
     */
    public double getCostBicicleta() {
        return CostBicicleta;
    }

    /**
     * @return the NombreCliente
     */
    public String getNombreCliente() {
        return NombreCliente;
    }
    
    public Object[] toArray(){
        Object[] data = {NombreCliente, RefBicicleta, fecha, CostBicicleta};
        return data;
    }
    
}
