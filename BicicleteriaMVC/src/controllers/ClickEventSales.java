/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.VentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.BicicletaModel;
import model.ClienteModel;
import model.VentaModel;
import view.ResultsVentaPanel;

/**
 *
 * @author Luis
 */
public class ClickEventSales implements ActionListener{
    
    private ResultsVentaPanel salesPanel;
    
    public ClickEventSales(ResultsVentaPanel salesPanel){
        this.salesPanel = salesPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        VentaDAO saleDAO = new VentaDAO();
        
        if(ae.getSource() == this.salesPanel.getBtnSearch()){
            int idClient = ((ClienteModel) this.salesPanel.getCbxClientLst().getSelectedItem()).getIdentificador();
            int idBicycle = ((BicicletaModel) this.salesPanel.getCbxBicycleLst().getSelectedItem()).getIdentificador();
            
  
            ArrayList<VentaModel> sales = saleDAO.showFilteredVentas(idClient, idBicycle);
            
            this.salesPanel.setTblResults(sales);
        }
    }
    
}
