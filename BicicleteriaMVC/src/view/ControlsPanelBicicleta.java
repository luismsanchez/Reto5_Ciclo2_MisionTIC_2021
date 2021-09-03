/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.ClickEventBicycle;
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
 * @author Luis
 */
public class ControlsPanelBicicleta extends JPanel{
    
    private JLabel lblIdBicicleta;
    private JTextField txtIdBicicleta;
    private JLabel lblRefBicicleta;
    private JTextField txtRefBicicleta;
    private JLabel lblCostoBicicleta;
    private JTextField txtCostoBicicleta;
    private JPanel panelNorth;
    private JPanel panelEast;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JLabel lblTitulo;
    private JLabel lblEast;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    
    public ControlsPanelBicicleta(){
        initComponents();
    }
    
    public void initComponents(){
        
        InitialData initialData = new InitialData();
        ClickEventBicycle clickEvent = new ClickEventBicycle(this);
        
        setLayout(new BorderLayout(20, 20));
        Font fontTitle = new Font("Century Gothic", Font.BOLD, 30);
        Font fontSubtitle = new Font("Century Schoolbook", Font.BOLD, 22);
        Font fontNormal = new Font("Century", Font.PLAIN, 18);
        
        
        this.panelNorth = new JPanel();
        this.panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 70));
        this.panelNorth.setBackground(Color.lightGray);
        this.lblTitulo = new JLabel("FORMULARIO DE BICICLETAS");
        this.lblTitulo.setFont(fontTitle);
        this.panelNorth.add(this.lblTitulo);
        add(panelNorth, BorderLayout.NORTH);
        
        this.panelEast = new JPanel();
        this.lblEast = new JLabel("     ");
        add(panelEast.add(lblEast), BorderLayout.EAST);
    
        
        this.panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(3, 2, 10, 70));
    
        // Identificador
        this.lblIdBicicleta = new JLabel("Id Bicicleta", JLabel.CENTER);
        lblIdBicicleta.setFont(fontSubtitle);
        panelCenter.add(this.lblIdBicicleta);
        
        this.txtIdBicicleta = new JTextField();
        this.getTxtIdBicicleta().setFont(fontNormal);
        panelCenter.add(this.getTxtIdBicicleta());
        
        // Referencia
        this.lblRefBicicleta = new JLabel("Referencia", JLabel.CENTER);
        lblRefBicicleta.setFont(fontSubtitle);
        panelCenter.add(this.lblRefBicicleta);
        
        this.txtRefBicicleta = new JTextField();
        this.getTxtRefBicicleta().setFont(fontNormal);
        panelCenter.add(this.getTxtRefBicicleta());
        
        // Costo
        this.lblCostoBicicleta = new JLabel("Precio", JLabel.CENTER);
        lblCostoBicicleta.setFont(fontSubtitle);
        panelCenter.add(this.lblCostoBicicleta);
        
        this.txtCostoBicicleta = new JTextField();
        this.getTxtCostoBicicleta().setFont(fontNormal);
        panelCenter.add(this.getTxtCostoBicicleta());
        
        add(panelCenter, BorderLayout.CENTER);
        
        this.panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 70));
        
        // Agregar
        this.btnAgregar = new JButton("Agregar");
        this.getBtnAgregar().setFont(fontNormal);
        panelSouth.add(getBtnAgregar());
        
        this.btnAgregar.addActionListener(clickEvent);
        
        
        // Actalizar
        this.btnActualizar = new JButton("Actualizar");
        this.getBtnActualizar().setFont(fontNormal);
        panelSouth.add(getBtnActualizar());
        
        this.btnActualizar.addActionListener(clickEvent);
        
        // Eliminar
        this.btnEliminar = new JButton("Eliminar");
        this.getBtnEliminar().setFont(fontNormal);
        panelSouth.add(getBtnEliminar());
        
        this.btnEliminar.addActionListener(clickEvent);
        
        add(panelSouth, BorderLayout.SOUTH);
    }

    /**
     * @return the txtIdBicicleta
     */
    public JTextField getTxtIdBicicleta() {
        return txtIdBicicleta;
    }

    /**
     * @return the txtRefBicicleta
     */
    public JTextField getTxtRefBicicleta() {
        return txtRefBicicleta;
    }

    /**
     * @return the txtCostoBicicleta
     */
    public JTextField getTxtCostoBicicleta() {
        return txtCostoBicicleta;
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
