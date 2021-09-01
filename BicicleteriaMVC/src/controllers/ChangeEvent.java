/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ControlsPanelVenta;
import view.ResultsVentaPanel;

/**
 *
 * @author Luis
 */
public class ChangeEvent implements ActionListener {
    // ### Attributes ###
    private ControlsPanelVenta controlspanelSale;
    private ResultsVentaPanel ResultsSale;
    
    // ### Constructor ###
    public ChangeEvent(ControlsPanelVenta controlspanelSale){
        this.controlspanelSale = controlspanelSale;
    }
    
    public ChangeEvent(ResultsVentaPanel ResultsSale){
        this.ResultsSale = ResultsSale;
    }
    
    // ### Methods ###

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlspanelSale.getCbxClientesLst()){
            // ....CONTINUE....
        }
    }
}
