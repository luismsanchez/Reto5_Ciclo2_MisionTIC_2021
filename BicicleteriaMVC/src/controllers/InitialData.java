/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.BicicletaDAO;
import access.ClienteDAO;
import access.VentaDAO;
import java.util.ArrayList;
import model.BicicletaModel;
import model.ClienteModel;
import model.VentaModel;

/**
 *
 * @author Luis
 */
public class InitialData {
    private ArrayList<BicicletaModel> bicycles = null;
    private ArrayList<ClienteModel> clients = null;
    private ArrayList<VentaModel> sales = null;
    
    
    public InitialData(){
        BicicletaDAO bicycleDAO = new BicicletaDAO();
        this.bicycles = bicycleDAO.getBicicletas();
        this.bicycles.add(0, new BicicletaModel(-1, "Todas las bicicletas", 0));
        
        ClienteDAO clientsDAO = new ClienteDAO();
        this.clients = clientsDAO.getClientes();
        this.clients.add(0, new ClienteModel(-1, "Todos los Clientes", "", 0));
        
        VentaDAO saleDAO = new VentaDAO();
        this.sales = saleDAO.showVentas();
    }

    /**
     * @return the bicycles
     */
    public ArrayList<BicicletaModel> getBicycles() {
        return bicycles;
    }

    /**
     * @return the clients
     */
    public ArrayList<ClienteModel> getClients() {
        return clients;
    }

    /**
     * @return the sales
     */
    public ArrayList<VentaModel> getSales() {
        return sales;
    }
    
    
    
}
