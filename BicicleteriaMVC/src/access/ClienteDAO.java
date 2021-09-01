/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.ClienteModel;
import utils.ConnectionDB;

/**
 *
 * @author Luis
 */
public class ClienteDAO {
    private Connection conn = null;
    
    
    public ArrayList<ClienteModel> getClientes(){
        ArrayList<ClienteModel> clientes = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT identificador, nombre, apellido, telefono FROM cliente;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                ClienteModel cliente = new ClienteModel(result.getInt(1), 
                        result.getString(2), result.getString(3), result.getInt(4));
                clientes.add(cliente);
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        return clientes;
    }
    
    
    public ClienteModel getCliente(int identificador){
        ClienteModel cliente = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT identificador, nombre, apellido, telefono FROM cliente "
                    +"WHERE identificador = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, identificador);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                cliente = new ClienteModel(result.getInt(1), 
                        result.getString(2), result.getString(3), result.getInt(4));
                break;
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        return cliente;
    }
    
    
    public void insertCliente(ClienteModel cliente){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO cliente(identificador, nombre, apellido, telefono) VALUES(?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, cliente.getIdentificador()); // --> Inyección de Datos
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido());
            statement.setInt(4, cliente.getTelefono());
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "¡El registro fué agregado existosamente!");
            else
                JOptionPane.showMessageDialog(null, "¡No se pudo agregar el registro!");
            
            conn.close(); //--> Cierra la conexión
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
    }
    
    
    public void updateCliente(ClienteModel cliente){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE cliente  SET nombre = ? WHERE identificador = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setInt(2, cliente.getIdentificador());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "¡El registro fué actualizado existosamente!");
            else
                JOptionPane.showMessageDialog(null, "¡No se pudo actualizar el registro!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
    }
    
    
    public void deleteCliente(int identificador){
        try{
          if(conn == null)
                conn = ConnectionDB.getConnection();
          
          String sql = "DELETE FROM cliente WHERE identificador = ?";
          PreparedStatement statement = conn.prepareStatement(sql);
          statement.setInt(1, identificador);
          
          int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "¡El registro fué eliminado existosamente!");
            else
                JOptionPane.showMessageDialog(null, "¡No se pudo eliminar el registro!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
    }
    
}
