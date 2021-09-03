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
import model.BicicletaModel;
import utils.ConnectionDB;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class BicicletaDAO {
    private Connection conn = null;
    
    public ArrayList<BicicletaModel> getBicicletas(){
        ArrayList<BicicletaModel> bicicletas = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT identificador, referencia, costo FROM bicicleta;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                BicicletaModel bicicleta = new BicicletaModel(result.getInt(1), 
                        result.getString(2), result.getDouble(3));
                bicicletas.add(bicicleta);
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        return bicicletas;
    }
    
    
    public BicicletaModel getBicicleta(int identificador){
        BicicletaModel bicicleta = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT identificador, referencia, costo FROM bicicleta WHERE identificador = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, identificador);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                bicicleta = new BicicletaModel(result.getInt(1), 
                            result.getString(2), result.getDouble(3));
                break;
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        return bicicleta;
    }   
    
    public ArrayList<BicicletaModel> getAllBicyclesByClient(int IdClient){
        ArrayList<BicicletaModel> bicicletas = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT bicicleta.identificador, referencia, costo FROM bicicleta\n" +
                "JOIN ventas ON ventas.Id_bicicleta = bicicleta.identificador\n" +
                "JOIN cliente ON ventas.Id_cliente = cliente.identificador\n" +
                "WHERE ventas.Id_cliente = ?;";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, IdClient); // --> Inyección de Datos
            
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                BicicletaModel bicicleta = new BicicletaModel(result.getInt(1), 
                        result.getString(2), result.getDouble(3));
                bicicletas.add(bicicleta);
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        return bicicletas;
    }
    
    
    public void insertBicicleta(BicicletaModel bicicleta){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO bicicleta(identificador, referencia, costo) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, bicicleta.getIdentificador()); // --> Inyección de Datos
            statement.setString(2, bicicleta.getReferencia());
            statement.setDouble(3, bicicleta.getCosto());
            
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
    
    public void updateBicicleta(BicicletaModel bicicleta){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE bicicleta SET referencia = ?, costo = ? WHERE identificador = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, bicicleta.getReferencia());
            statement.setDouble(2, bicicleta.getCosto());
            statement.setInt(3, bicicleta.getIdentificador());
            
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
    
    public void deleteBicicleta(int identificador){
        try{
          if(conn == null)
                conn = ConnectionDB.getConnection();
          
          String sql = "DELETE FROM bicicleta WHERE identificador = ?";
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
