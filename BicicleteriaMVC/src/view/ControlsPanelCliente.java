/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.ClickEventConsumer;
import controllers.InitialData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PCE
 */
public class ControlsPanelCliente extends JPanel
{
    private JLabel lblIdCliente;
    private JTextField txtIdCliente;
    private JLabel lblNombreCliente;
    private JTextField txtNombreCliente;
    private JLabel lblApellidoCliente;
    private JTextField txtApellidoCliente;
    private JLabel lblTelefonoCliente;
    private JTextField txtTelefonoCliente;
    private JPanel panelNorth;
    private JPanel panelEast;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JLabel lblTitulo;
    private JLabel lblEast;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    
    public ControlsPanelCliente()
    {
        initComponents();
    }
    
    public void initComponents()
    {
            InitialData initialData = new InitialData();
            
            setLayout(new BorderLayout(20,20));
            Font fontTitle = new Font("Century Gothic", Font.BOLD, 30);
            Font fontSubtitle = new Font("Century Schoolbook", Font.BOLD, 22);
            Font fontNormal = new Font("Century", Font.PLAIN, 18);
            
            this.panelNorth = new JPanel();
            this.panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 20 ,70));
            this.panelNorth.setBackground(Color.LIGHT_GRAY);
            this.lblTitulo = new JLabel("FORMULARIO DE CLIENTES");
            this.lblTitulo.setFont(fontTitle);
            this.panelNorth.add(lblTitulo);
            add(panelNorth,BorderLayout.NORTH);
            
            
            this.panelEast = new JPanel();
            this.lblEast = new JLabel("     ");
            add(panelEast.add(lblEast), BorderLayout.EAST); 
            
            this.panelCenter = new JPanel();
            panelCenter.setLayout(new GridLayout(4 ,2 , 10 , 40));
            
            //Identificador
            this.lblIdCliente = new JLabel("Id Cliente", JLabel.CENTER);
            lblIdCliente.setFont(fontSubtitle);
            panelCenter.add(this.lblIdCliente);
            
            this.txtIdCliente = new JTextField();
            this.getTxtIdCliente().setFont(fontNormal);
            panelCenter.add(this.getTxtIdCliente());
            
            //Nombre
            this.lblNombreCliente = new JLabel("Nombre", JLabel.CENTER);
            lblNombreCliente.setFont(fontSubtitle);
            panelCenter.add(this.lblNombreCliente);
            
            this.txtNombreCliente = new JTextField();
            this.getTxtNombreCliente().setFont(fontNormal);
            panelCenter.add(this.getTxtNombreCliente());
            
            //Apellido
            this.lblApellidoCliente = new JLabel("Apellido", JLabel.CENTER);
            lblApellidoCliente.setFont(fontSubtitle);
            panelCenter.add(this.lblApellidoCliente);
            
            this.txtApellidoCliente = new JTextField();
            this.getTxtApellidoCliente().setFont(fontNormal);
            panelCenter.add(this.getTxtApellidoCliente());
            
            //Telefono
            this.lblTelefonoCliente = new JLabel("Telefono", JLabel.CENTER);
            lblTelefonoCliente.setFont(fontSubtitle);
            panelCenter.add(this.lblTelefonoCliente);
            
            this.txtTelefonoCliente = new JTextField();
            this.getTxtTelefonoCliente().setFont(fontNormal);
            panelCenter.add(this.getTxtTelefonoCliente());
            
            add(panelCenter, BorderLayout.CENTER);
            
            this.panelSouth = new JPanel();
            this.panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 20 ,70));
            
            //Agregar
            this.btnAgregar = new JButton("Agregar");
            this.getBtnAgregar().setFont(fontNormal);
            panelSouth.add(getBtnAgregar());
            //ClickEvent Agregar
            ClickEventConsumer clickEvent   = new ClickEventConsumer(this);
            this.getBtnAgregar().addActionListener(clickEvent);
            
            //Actualizar
            this.btnActualizar = new JButton("Actualizar");
            this.getBtnActualizar().setFont(fontNormal);
            panelSouth.add(getBtnActualizar());
            //ClickEvent Actualizar
            this.getBtnActualizar().addActionListener(clickEvent);
            
            //Eliminar
            this.btnEliminar = new JButton("Eliminar");
            this.getBtnEliminar().setFont(fontNormal);
            panelSouth.add(getBtnEliminar());
            //ClickEvent Eliminar
            this.getBtnEliminar().addActionListener(clickEvent);
            
            add(panelSouth, BorderLayout.SOUTH);
    }

    /**
     * @return the txtIdCliente
     */
    public JTextField getTxtIdCliente() {
        return txtIdCliente;
    }

    /**
     * @return the txtNombreCliente
     */
    public JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    /**
     * @return the txtApellidoCliente
     */
    public JTextField getTxtApellidoCliente() {
        return txtApellidoCliente;
    }

    /**
     * @return the txtTelefonoCliente
     */
    public JTextField getTxtTelefonoCliente() {
        return txtTelefonoCliente;
    }

    /**
     * @return the btnAgregar
     */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    /**
     * @return the btnActualizar
     */
    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    /**
     * @return the btnEliminar
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }
}
