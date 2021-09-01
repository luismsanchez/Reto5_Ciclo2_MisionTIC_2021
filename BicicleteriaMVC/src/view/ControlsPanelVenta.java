/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.ChangeEvent;
import controllers.ClickEvent;
import controllers.InitialData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.BicicletaModel;
import model.ClienteModel;

/**
 *
 * @author Luis
 */
public class ControlsPanelVenta  extends JPanel {
    // ### Attributes ###
    private JLabel lblClientes;
    private JComboBox<ClienteModel> cbxClientesLst;
    private JLabel lblBicicletas;
    private JComboBox<BicicletaModel> cbxBicicletasLst;
    private JLabel lblFecha;
    private JTextField txtFecha;
    private JButton btnAddVenta;
    private JButton btnCreateCliente;
    private JButton btnCreateBicicleta;
    private JButton btnShowVentas;
    private JPanel panelFields;
    private JPanel panelButtons;
    private JPanel panelTop;
    private JLabel lblTop;
    private JLabel lblRight;
    private JLabel lblLeft;
    private JPanel panelRight;
    private JPanel panelLeft;
    
    // ### Constructor ###
    public ControlsPanelVenta(){
        initComponents();
    }
    
    // ### Methods ###
    public void initComponents(){
        
        InitialData initialData = new InitialData();
        
        setLayout(new BorderLayout(20, 20));
        Font fontTitle = new Font("Century Gothic", Font.BOLD, 30);
        Font fontSubtitle = new Font("Century Schoolbook", Font.BOLD, 22);
        Font fontNormal = new Font("Century", Font.PLAIN, 18);
        
        this.panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 70));
        panelTop.setBackground(Color.lightGray);
        this.lblTop = new JLabel("FORMULARIO DE VENTAS");
        lblTop.setFont(fontTitle);
        panelTop.add(lblTop);
        add(panelTop, BorderLayout.NORTH);
        
        this.panelRight = new JPanel();
        this.lblRight = new JLabel("     ");
        add(panelRight.add(lblRight), BorderLayout.EAST);
        
        this.panelLeft = new JPanel();
        this.lblLeft = new JLabel("     ");
        add(panelLeft.add(lblLeft), BorderLayout.WEST);
        
        panelFields = new JPanel();
        panelFields.setLayout(new GridLayout(3, 2, 10, 70));
        
        
        
        // Clients selection
        this.lblClientes = new JLabel("Cliente", JLabel.CENTER);
        lblClientes.setFont(fontSubtitle);
        panelFields.add(this.getLblClientes());
        
        this.cbxClientesLst = new JComboBox();
        this.cbxClientesLst.setModel(new DefaultComboBoxModel<>(initialData.getClients().toArray(new ClienteModel[initialData.getClients().size()])));
        this.cbxClientesLst.setSelectedIndex(0);
        this.cbxClientesLst.setFont(fontNormal);
        panelFields.add(this.getCbxClientesLst());
        
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxClientesLst().addActionListener(changeEvent);
        
        // Bicycles selection
        this.lblBicicletas = new JLabel("Bicicleta", JLabel.CENTER);
        this.lblBicicletas.setFont(fontSubtitle);
        panelFields.add(this.getLblBicicletas());
        
        this.cbxBicicletasLst = new JComboBox();
        this.cbxBicicletasLst.setFont(fontNormal);
        this.cbxBicicletasLst.setModel(new DefaultComboBoxModel<>(initialData.getBicycles().toArray(new BicicletaModel[initialData.getBicycles().size()])));
        this.cbxBicicletasLst.setSelectedIndex(0);
        panelFields.add(this.getCbxBicicletasLst());
        
        this.getCbxBicicletasLst().addActionListener(changeEvent);
        
        // Date record
        this.lblFecha = new JLabel("Fecha:", JLabel.CENTER);
        this.lblFecha.setFont(fontSubtitle);
        panelFields.add(this.getLblFecha());
        
        this.txtFecha = new JTextField();
        this.txtFecha.setFont(fontNormal);
        //txtFecha.setText(new Date().toString());
        panelFields.add(this.getTxtFecha());
        
        add(panelFields, BorderLayout.CENTER);
        
        panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        //panelButtons.setBackground(Color.lightGray);
        
        // Add sale button
        this.btnAddVenta = new JButton("Agregar Venta");
        this.btnAddVenta.setFont(fontNormal);
        panelButtons.add(this.getBtnAddVenta());
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.getBtnAddVenta().addActionListener(clickEvent);
        
        // Create client button
        this.btnCreateCliente = new JButton("Crear Cliente");
        this.btnCreateCliente.setFont(fontNormal);
        panelButtons.add(this.getBtnCreateCliente());

        this.getBtnCreateCliente().addActionListener(clickEvent);
        
        // Create bicycle button
        this.btnCreateBicicleta = new JButton("Crear Bicicleta");
        this.btnCreateBicicleta.setFont(fontNormal);
        panelButtons.add(this.getBtnCreateBicicleta());

        this.getBtnCreateBicicleta().addActionListener(clickEvent);
        
        // Show sales button
        this.btnShowVentas = new JButton("Ver Ventas");
        this.btnShowVentas.setFont(fontNormal);
        panelButtons.add(this.getBtnShowVentas());
        
        this.getBtnShowVentas().addActionListener(clickEvent);
        
        add(panelButtons, BorderLayout.SOUTH);
    }

    /**
     * @return the lblClientes
     */
    public JLabel getLblClientes() {
        return lblClientes;
    }

    /**
     * @return the cbxClientesLst
     */
    public JComboBox<ClienteModel> getCbxClientesLst() {
        return cbxClientesLst;
    }

    /**
     * @return the lblBicicletas
     */
    public JLabel getLblBicicletas() {
        return lblBicicletas;
    }

    /**
     * @return the cbxBicicletasLst
     */
    public JComboBox<BicicletaModel> getCbxBicicletasLst() {
        return cbxBicicletasLst;
    }

    /**
     * @return the fecha
     */
    public JLabel getLblFecha() {
        return lblFecha;
    }

    /**
     * @return the txtFecha
     */
    public JTextField getTxtFecha() {
        return txtFecha;
    }

    /**
     * @return the btnAddVenta
     */
    public JButton getBtnAddVenta() {
        return btnAddVenta;
    }

    /**
     * @return the btnCreateCliente
     */
    public JButton getBtnCreateCliente() {
        return btnCreateCliente;
    }

    /**
     * @return the btnCreateBicicleta
     */
    public JButton getBtnCreateBicicleta() {
        return btnCreateBicicleta;
    }

    /**
     * @return the btnShowVentas
     */
    public JButton getBtnShowVentas() {
        return btnShowVentas;
    }
}
