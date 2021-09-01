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
    private ResultsVentaPanel ResultsSale;
    
    /**
     * Contructor of the class
     * @param ctrlPanelSales 
     */
    public ClickEvent(ControlsPanelVenta ctrlPanelSales){
        this.ctrlPanelSales = ctrlPanelSales;
    }
    
    public ClickEvent(ResultsVentaPanel ResultsSale){
        this.ResultsSale = ResultsSale;
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
        
        //if(ae.getSource() == this.getResultsSale().getBtnBack()){
            //new VentaWindow();
        //}
    }

    /**
     * @return the ctrlPanelSales
     */
    public ControlsPanelVenta getCtrlPanelSales() {
        return ctrlPanelSales;
    }

    /**
     * @return the ResultsSale
     */
    public ResultsVentaPanel getResultsSale() {
        return ResultsSale;
    }
    
}
