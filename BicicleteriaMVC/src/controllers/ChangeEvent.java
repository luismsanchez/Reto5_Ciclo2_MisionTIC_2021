/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.BicicletaDAO;
import access.ClienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.BicicletaModel;
import model.ClienteModel;
import view.ResultsVentaPanel;

/**
 *
 * @author Luis
 */
public class ChangeEvent implements ActionListener {
    // ### Attributes ###
    private ResultsVentaPanel ResultsSale;
    
    // ### Constructor ###
    
    public ChangeEvent(ResultsVentaPanel ResultsSale){
        this.ResultsSale = ResultsSale;
    }
    
    // ### Methods ###

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.ResultsSale.getCbxClientLst()){
            
            BicicletaDAO bicycleDAO = new BicicletaDAO();
            ArrayList<BicicletaModel> bicycles = null;
            int client = ((ClienteModel) this.ResultsSale.getCbxClientLst().getSelectedItem()).getIdentificador();
            
            if(client == -1){
                bicycles = bicycleDAO.getBicicletas();
                bicycles.add(0, new BicicletaModel(-1, "Todas las bicicletas", 0));
            }
            else {
                bicycles = bicycleDAO.getAllBicyclesByClient(client);
                bicycles.add(0, new BicicletaModel(-1, "Todas las bicicletas", 0));
            }
            
            this.ResultsSale.setCbxBicycleLst(bicycles);
        }
        
        if(actionEvent.getSource() == this.ResultsSale.getCbxBicycleLst()){
            
            ClienteDAO clientDAO = new ClienteDAO();
            ArrayList<ClienteModel> clients = null;
            int bicycle = ((BicicletaModel) this.ResultsSale.getCbxBicycleLst().getSelectedItem()).getIdentificador();
            
            if(bicycle == -1){
                clients = clientDAO.getClientes();
                clients.add(0, new ClienteModel(-1, "Todos los Clientes", "", 0));
            }
            else {
                clients = clientDAO.getAllClientesByBicycle(bicycle);
                clients.add(0, new ClienteModel(-1, "Todos los Clientes", "", 0));
            }
            
            this.ResultsSale.setCbxClientLst(clients);
        }
    }
}
