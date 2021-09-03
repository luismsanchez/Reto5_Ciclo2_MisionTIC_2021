/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import access.ClienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ClienteModel;
import view.ControlsPanelCliente;

/**
 *
 * @author PCE
 */
public class ClickEventConsumer implements ActionListener
{
    private ControlsPanelCliente ctrlPanelConsumer;
    
    public ClickEventConsumer (ControlsPanelCliente ctrlPanelConsumer)
    {
        this.ctrlPanelConsumer = ctrlPanelConsumer;
    }
    
    @Override
    public void actionPerformed (ActionEvent ae)
    {
        ClienteDAO consumerDAO = new ClienteDAO();
        
        //Click Boton Agregar
        if (ae.getSource() == this.ctrlPanelConsumer.getBtnAgregar())
        {
            int IdConsumer = Integer.parseInt(this.ctrlPanelConsumer.getTxtIdCliente().getText());
            String NameConsumer = this.ctrlPanelConsumer.getTxtNombreCliente().getText();
            String LastNameConsumer = this.ctrlPanelConsumer.getTxtApellidoCliente().getText();
            int PhoneConsumer = Integer.parseInt(this.ctrlPanelConsumer.getTxtTelefonoCliente().getText());
            
            ClienteModel consumer = new ClienteModel(IdConsumer, NameConsumer, LastNameConsumer, PhoneConsumer);
            consumerDAO.insertCliente(consumer);
        }
        
        //Click Boton Actualizar
        if (ae.getSource() == this.ctrlPanelConsumer.getBtnActualizar())
        {
            int IdConsumer = Integer.parseInt(this.ctrlPanelConsumer.getTxtIdCliente().getText());
            String NameConsumer = this.ctrlPanelConsumer.getTxtNombreCliente().getText();
            String LastNameConsumer = this.ctrlPanelConsumer.getTxtApellidoCliente().getText();
            int PhoneConsumer = Integer.parseInt(this.ctrlPanelConsumer.getTxtTelefonoCliente().getText());
            
            ClienteModel consumer = new ClienteModel(IdConsumer, NameConsumer, LastNameConsumer, PhoneConsumer);
            consumerDAO.updateCliente(consumer);
        }
        
        //Click Boton Eliminar
        if (ae.getSource() == this.ctrlPanelConsumer.getBtnEliminar())
        {
            int IdConsumer = Integer.parseInt(this.ctrlPanelConsumer.getTxtIdCliente().getText());
            
            consumerDAO.deleteCliente(IdConsumer);
        }
    }
}
