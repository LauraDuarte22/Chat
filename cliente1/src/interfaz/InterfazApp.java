/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Controlador.ControladorClient;
import java.awt.Color;
import javax.swing.*;
import util.Util;

/**
 *
 * @author admin
 */
public class InterfazApp extends JFrame {

    private ControladorClient ctrl;
    private PanelConversacion pnlConversacion;
    private static PanelEnviar pnlEnviar;

    public InterfazApp(ControladorClient ctrl) {
        this.ctrl = ctrl;
        ctrl.conectar(pnlConversacion, pnlEnviar);
        setTitle("Cliente");
        getContentPane().setLayout(null);
        
        pnlConversacion = new PanelConversacion(pnlEnviar, ctrl);
        pnlConversacion.setBounds(20, 20, 280, 360);
        getContentPane().add(pnlConversacion);
        getContentPane().add(new JLabel());
     
        pnlEnviar = new PanelEnviar(pnlConversacion);
        pnlEnviar.setBounds(25,400,275, 90);
        getContentPane().add(pnlEnviar);
        getContentPane().add(new JLabel());
        getContentPane().add(new JLabel());
      

        setResizable(false);
        setSize(320, 520);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Util.centrarVentana(this);

    }

    public void toReceive(String msgReceive) {
        System.out.println(msgReceive);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp(new ControladorClient());
        frmMain.setVisible(true);
      
    }

}
