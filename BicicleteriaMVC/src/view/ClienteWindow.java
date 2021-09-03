package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class ClienteWindow extends JFrame
{
    public ClienteWindow()
    {
        initComponets();
    }
    
    private void initComponets()
    {
        setTitle("Cliente");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        add(new ControlsPanelCliente());
        setSize(1040 , 720);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        
        setVisible(true);
    }
}
