/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.ChangeEvent;
import controllers.ClickEvent;
import controllers.ClickEventSales;
import controllers.InitialData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.BicicletaModel;
import model.ClienteModel;
import model.VentaModel;

/**
 *
 * @author Luis
 */
public class ResultsVentaPanel  extends JPanel{
    
    private JLabel lblClient;
    private JComboBox<ClienteModel> cbxClientLst;
    private JLabel lblBicycle;
    private JComboBox<BicicletaModel> cbxBicycleLst;
   
    private JButton btnSearch;
 
    private JTable tblResults;
    private JPanel panelFloor;
    private JPanel panelFloor2;
    
    
    /**
     * 
     * @param tblResults 
     */
    public ResultsVentaPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    
    public void initComponents(){
        
        InitialData initialData = new InitialData();
        ClickEventSales clickEvent = new ClickEventSales(this);
        ChangeEvent changeEvent = new ChangeEvent(this);
        
        setLayout(new GridLayout(3, 1, 50, 50));
        Font fontTitle = new Font("Century Gothic", Font.BOLD, 30);
        Font fontSubtitle = new Font("Century Schoolbook", Font.BOLD, 22);
        Font fontNormal = new Font("Century", Font.PLAIN, 18);
        
        
        // Complete Ventas info
        this.setTblResults(initialData.getSales());
        
        
        
        this.panelFloor = new JPanel();
        this.panelFloor.setLayout(new GridLayout(1, 2, 40, 100));
        
        this.panelFloor2 = new JPanel();
        this.panelFloor2.setLayout(new FlowLayout());
        
        //Client selection
        this.lblClient = new JLabel("Cliente", JLabel.CENTER);
        lblClient.setFont(fontSubtitle);
        panelFloor.add(lblClient);
        
        this.cbxClientLst = new JComboBox();
        this.cbxClientLst.setModel(new DefaultComboBoxModel<>(initialData.getClients().toArray(new ClienteModel[initialData.getClients().size()])));
        this.cbxClientLst.setSelectedIndex(0);
        this.cbxClientLst.setFont(fontNormal);
        panelFloor.add(cbxClientLst);

        this.getCbxClientLst().addActionListener(changeEvent);
        
        
        // Bicycles selection
        this.lblBicycle = new JLabel("Bicicleta", JLabel.CENTER);
        lblBicycle.setFont(fontSubtitle);
        panelFloor.add(lblBicycle);
        
        this.cbxBicycleLst = new JComboBox();
        this.cbxBicycleLst.setModel(new DefaultComboBoxModel<>(initialData.getBicycles().toArray(new BicicletaModel[initialData.getBicycles().size()])));
        this.cbxBicycleLst.setSelectedIndex(0);
        this.cbxBicycleLst.setFont(fontNormal);
        panelFloor.add(cbxBicycleLst);
        
        //this.cbxBicycleLst.addActionListener(changeEvent);
        
        //this.panelRight = new JPanel();
        
        //Search button
        this.btnSearch = new JButton("Buscar");
        btnSearch.setFont(fontNormal);
        panelFloor2.add(btnSearch);
        
        
        this.btnSearch.addActionListener(clickEvent);
        
        
        add(panelFloor);
        add(panelFloor2);
        
        
    }

    /**
     * @return the lblClient
     */
    public JLabel getLblClient() {
        return lblClient;
    }

    /**
     * @return the cbxClientLst
     */
    public JComboBox<ClienteModel> getCbxClientLst() {
        return cbxClientLst;
    }

    

    /**
     * @return the lblBicycle
     */
    public JLabel getLblBicycle() {
        return lblBicycle;
    }

    /**
     * @return the cbxBicycleLst
     */
    public JComboBox<BicicletaModel> getCbxBicycleLst() {
        return cbxBicycleLst;
    }

    /**
     * @param cbxBicycleLst the cbxBicycleLst to set
     */
    public void setCbxBicycleLst(ArrayList<BicicletaModel> bicycles) {
        this.cbxBicycleLst.setModel(new DefaultComboBoxModel<>(bicycles.toArray(new BicicletaModel[bicycles.size()])));
        this.cbxBicycleLst.setSelectedIndex(0);
    }
    
    /**
     * @param cbxClientLst the cbxClientLst to set
     */
    public void setCbxClientLst(ArrayList<ClienteModel> clients) {
        this.cbxClientLst.setModel(new DefaultComboBoxModel<>(clients.toArray(new ClienteModel[clients.size()])));
        this.cbxClientLst.setSelectedIndex(0);
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the tblResults
     */
    public void setTblResults(ArrayList<VentaModel> sales) {
        String[] headers = {"Nombre", "Referencia", "Fecha", "Costo"};
        this.getTblResults().removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.getTblResults().setModel(tableModel);
        for(int i=0; i<sales.size(); i++){
            tableModel.addRow(sales.get(i).toArray());
        }
    }

    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

}
