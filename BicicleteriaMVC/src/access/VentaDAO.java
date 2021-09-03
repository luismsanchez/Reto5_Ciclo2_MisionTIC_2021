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

import model.VentaModel;
import utils.ConnectionDB;

/**
 *
 * @author Luis
 */
public class VentaDAO {
    private Connection conn = null;
    
    
    public ArrayList<VentaModel> getVentas(){
        ArrayList<VentaModel> ventas = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT identificador, Id_cliente, fecha, Id_bicicleta FROM ventas;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                VentaModel venta = new VentaModel(result.getInt(1), 
                        result.getInt(2), result.getString(3), result.getInt(4));
                ventas.add(venta);
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        return ventas;
    }
    
    public VentaModel getVenta(int identificador){
        VentaModel venta = null;
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT identificador, Id_cliente, fecha, Id_bicicleta FROM ventas "
                    +"WHERE identificador = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, identificador);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                venta = new VentaModel(result.getInt(1), 
                        result.getInt(2), result.getString(3), result.getInt(4));
                break;
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        return venta;
    }
    
    
    public void insertVenta(VentaModel venta){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO ventas(Id_cliente, fecha, Id_bicicleta) VALUES(?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, venta.getIdCliente_fk()); // --> Inyección de Datos
            statement.setString(2, venta.getFecha());
            statement.setInt(3, venta.getIdBicicleta_fk());
            
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
    
    
    public void updateVenta(VentaModel venta){
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE ventas SET Id_bicicleta = ? WHERE identificador = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, venta.getIdBicicleta_fk());
            statement.setInt(2, venta.getIdentificador());
            
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
    
    
    public void deleteVenta(int identificador){
        try{
          if(conn == null)
                conn = ConnectionDB.getConnection();
          
          String sql = "DELETE FROM ventas WHERE identificador = ?";
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
    
    
    public ArrayList<VentaModel> showVentas(){
        ArrayList<VentaModel> ventas = new ArrayList();
        try{
          if(conn == null)
                conn = ConnectionDB.getConnection();
          
          String sql = "SELECT concat(nombre,concat(\" \",apellido)) AS \"Nombre\", referencia AS \"Referencia\",\n" +
                " fecha AS \"Fecha\", costo AS \"Costo\"\n" +
                "FROM ventas\n" +
                "JOIN cliente ON ventas.Id_cliente = cliente.identificador\n" +
                "JOIN bicicleta ON ventas.Id_bicicleta = bicicleta.identificador\n" +
                "ORDER BY fecha;";
          Statement statement = conn.createStatement();
          ResultSet result = statement.executeQuery(sql);
          
            while(result.next()){
                VentaModel venta = new VentaModel(result.getString(1), result.getString(2),
                             result.getString(3), result.getDouble(4));
                ventas.add(venta);
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        
        return ventas;
    }
    
    
    public ArrayList<VentaModel> showFilteredVentas(int idClient, int idBicycle){
        
        ArrayList<VentaModel> ventas = new ArrayList();
        int case_ = -1;
        
        try{
          if(conn == null)
                conn = ConnectionDB.getConnection();
          
          String sql = "SELECT concat(nombre,concat(\" \",apellido)) AS \"Nombre\", referencia AS \"Referencia\"," +
                " fecha AS \"Fecha\", costo AS \"Costo\" " +
                "FROM ventas " +
                "JOIN cliente ON ventas.Id_cliente = cliente.identificador " +
                "JOIN bicicleta ON ventas.Id_bicicleta = bicicleta.identificador " ;
                
          
          if(idClient != -1){
              if(idBicycle != -1){
                  sql += " WHERE cliente.identificador=? AND bicicleta.identificador=? ;";
                  case_ = 1;
              }
              else {
                  sql += " WHERE cliente.identificador=? ;";
                  case_ = 2;
              }
          }
          else if(idBicycle != -1){
                sql += " WHERE bicicleta.identificador=? ;";
                case_ = 3;
          }
          else{
                sql += " ORDER BY fecha ;";
                case_ = 4;
          }
          
          PreparedStatement statement = conn.prepareStatement(sql);
          switch (case_){
              case 1:
                  statement.setInt(1, idClient);
                  statement.setInt(2, idBicycle);
                  break;
              case 2:
                  statement.setInt(1, idClient);
                  break;
              case 3:
                  statement.setInt(1, idBicycle);
                  break;
                  
          }
          
          ResultSet result = statement.executeQuery();
          
            while(result.next()){
                VentaModel venta = new VentaModel(result.getString(1), result.getString(2),
                             result.getString(3), result.getDouble(4));
                ventas.add(venta);
            }
            conn.close(); //--> Cierra la conexión
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                + "\nError : " + ex.getMessage());
        }
        
        return ventas;
    }
    
    

}
