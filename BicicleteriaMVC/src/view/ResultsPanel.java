/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author Luis
 */
public class ResultsPanel extends JPanel {
    
    // ### Atributos ###
    private JTable tblResults;
    private JScrollPane jspPane;
    
    
    // ### Constructor ###
    public ResultsPanel(){
        initComponents();
    }
    
    
    // ### Métodos ###
    public void initComponents(){
        this.setTblResults(new JTable());
        this.getTblResults().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        this.jspPane = new JScrollPane(this.getTblResults());
        add(jspPane, BorderLayout.CENTER);
        
        setPreferredSize(new Dimension(1020, 800));
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
}
