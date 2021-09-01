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
public class ClienteModel {
    // ### Atributos ###
    private int identificador;
    private String nombre;
    private String apellido;
    private int telefono;
    
    /**
     * Constructor para manejo de la tabla
     * @param identificador
     * @param nombre
     * @param apellido
     * @param telefono 
     */
    public ClienteModel(int identificador, String nombre, 
            String apellido, int telefono){
        this.identificador  = identificador;
        this.nombre         = nombre;
        this.apellido       = apellido;
        this.telefono       = telefono;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public Object[] toArray(){
        Object[] data = {identificador, nombre, apellido, telefono};
        return data;
    }
    
    public String toString(){
        return nombre + " " + apellido;
    }
}
