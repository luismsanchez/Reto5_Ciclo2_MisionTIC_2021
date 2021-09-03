/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.BicicletaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BicicletaModel;
import view.ControlsPanelBicicleta;

/**
 *
 * @author Luis
 */
public class ClickEventBicycle implements ActionListener{
    
    private ControlsPanelBicicleta ctrlPanelBicycle;
    
    public ClickEventBicycle(ControlsPanelBicicleta ctrlPanelBicycle){
        this.ctrlPanelBicycle = ctrlPanelBicycle;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        BicicletaDAO bicycleDAO = new BicicletaDAO();
        
        if(ae.getSource() == this.ctrlPanelBicycle.getBtnAgregar()){
            int IdBicycle = Integer.parseInt(this.ctrlPanelBicycle.getTxtIdBicicleta().getText());
            String Reference = this.ctrlPanelBicycle.getTxtRefBicicleta().getText();
            double Price = Double.parseDouble(this.ctrlPanelBicycle.getTxtCostoBicicleta().getText());
            
            BicicletaModel bicycle = new BicicletaModel(IdBicycle, Reference, Price);
            bicycleDAO.insertBicicleta(bicycle);
        }
        
        if(ae.getSource() == this.ctrlPanelBicycle.getBtnActualizar()){
            int IdBicycle = Integer.parseInt(this.ctrlPanelBicycle.getTxtIdBicicleta().getText());
            String Reference = this.ctrlPanelBicycle.getTxtRefBicicleta().getText();
            double Price = Double.parseDouble(this.ctrlPanelBicycle.getTxtCostoBicicleta().getText());
            
            BicicletaModel bicycle = new BicicletaModel(IdBicycle, Reference, Price);
            bicycleDAO.updateBicicleta(bicycle);
        }
        
        if(ae.getSource() == this.ctrlPanelBicycle.getBtnEliminar()){
            int IdBicycle = Integer.parseInt(this.ctrlPanelBicycle.getTxtIdBicicleta().getText());
            
            bicycleDAO.deleteBicicleta(IdBicycle);
        }
    }
   
    
}
