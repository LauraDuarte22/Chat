/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Controlador.ControladorClient;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author admin
 */


public class PanelEnviar extends JPanel {

    protected JTextArea textField;
    private JButton button;
    private Icon icon = new ImageIcon("C:/Users/admin/OneDrive/Documents/NetBeansProjects/cliente1/img/send.png");
    private PanelConversacion pnlConversacion;
    private ControladorClient ctrl;

    public PanelEnviar(PanelConversacion pnlConversacion) {
        this.pnlConversacion = pnlConversacion;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        textField = new JTextArea();
        textField.setLineWrap(true);
        textField.setBounds(0, 0, 200, 60);
        textField.setWrapStyleWord(true);

        button = new JButton();
        button.setIcon(icon);
        Insets insets = new Insets(0, 0, 0, 0);
        button.setMargin(insets);
        button.addActionListener(new ActionClick(this, pnlConversacion, ctrl));

        //Border
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        textField.setBorder(border);

        add(textField);
        add(button);

    }

}

class ActionClick implements ActionListener {

    private PanelConversacion pnlConversacion;
    private PanelEnviar pnlEnviar;
    private ControladorClient ctrl;

    public ActionClick(PanelEnviar pnlEnviar, PanelConversacion pnlConversacion, ControladorClient ctrl) {
        this.pnlEnviar = pnlEnviar;
        this.pnlConversacion = pnlConversacion;
        this.ctrl = ctrl;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //ctrl.encriptar(pnlEnviar.textField.getText());
        pnlConversacion.mostrarMensaje(pnlEnviar.textField.getText());
        pnlEnviar.textField.setText("");

    }

}
