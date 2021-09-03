/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.VentaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.BicicletaModel;
import model.ClienteModel;
import model.VentaModel;
import view.BicicletaWindow;
import view.ClienteWindow;
import view.ControlsPanelVenta;
import view.ResultsPanel;
import view.ResultsVentaPanel;
import view.ResultsVentaWindow;
import view.VentaWindow;

/**
 *
 * @author Luis
 */
public class ClickEvent implements ActionListener{
    // ### Attributes ###
    private ControlsPanelVenta ctrlPanelSales;

    
    /**
     * Contructor of the class
     * @param ctrlPanelSales 
     */
    public ClickEvent(ControlsPanelVenta ctrlPanelSales){
        this.ctrlPanelSales = ctrlPanelSales;
    }
    
    
    // ### Methods ###
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        VentaDAO saleDAO = new VentaDAO();
        
        if(ae.getSource() == this.getCtrlPanelSales().getBtnAddVenta()){
            int idClient = ((ClienteModel) this.getCtrlPanelSales().getCbxClientesLst().getSelectedItem()).getIdentificador();
            int idBicycle = ((BicicletaModel) this.getCtrlPanelSales().getCbxBicicletasLst().getSelectedItem()).getIdentificador();
            String date = this.getCtrlPanelSales().getTxtFecha().getText();
            
            VentaModel sale = new VentaModel(idClient, date, idBicycle);
            saleDAO.insertVenta(sale);  
        }
        
        if(ae.getSource() == this.getCtrlPanelSales().getBtnShowVentas()){
            new ResultsVentaWindow();
        }
        
        if(ae.getSource() == this.ctrlPanelSales.getBtnCreateBicicleta()){
            new BicicletaWindow();
        }
        
        if(ae.getSource() == this.ctrlPanelSales.getBtnCreateCliente()){
            new ClienteWindow();
        }
        
    }

    /**
     * @return the ctrlPanelSales
     */
    public ControlsPanelVenta getCtrlPanelSales() {
        return ctrlPanelSales;
    }
    
}
