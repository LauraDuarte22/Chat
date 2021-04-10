/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javax.swing.JFrame;
import controlador.ControladorServer;
import javax.swing.JLabel;
import util.Util;

/**
 *
 * @author admin
 */

// INTERFAZ SERVIDOR
public class InterfazApp extends JFrame {

    private ControladorServer ctrl;
    private PanelConversacion pnlConversacion;

    public InterfazApp(ControladorServer ctrl) {
        this.ctrl = ctrl;
        
        setTitle("Server");
        getContentPane().setLayout(null);
        
        pnlConversacion = new PanelConversacion(ctrl);
       pnlConversacion.setBounds(20, 20, 280, 450);
        getContentPane().add(pnlConversacion);
        getContentPane().add(new JLabel());
        
        ctrl.conectar(pnlConversacion);
        setResizable(false);
        setSize(335, 520);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Util.centrarVentana(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp(new ControladorServer());
        frmMain.setVisible(true);
    }

}
