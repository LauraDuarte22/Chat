/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.*;
import javax.swing.*;
import Controlador.ControladorClient;
import javax.swing.border.Border;

/**
 *
 * @author admin
 */
public class PanelConversacion extends JPanel {

    private JTextArea textfield;
    private Border border;
    private PanelEnviar pnlEnviar;
    private ControladorClient ctrl;

    public PanelConversacion(PanelEnviar pnlEnviar, ControladorClient ctrl) {
        this.pnlEnviar = pnlEnviar;
        this.ctrl = ctrl;
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        textfield = new JTextArea();;
        textfield.setEditable(false);
        textfield.setBounds(1, 20, 240, 260);
        textfield.setForeground(Color.RED);
        textfield.setLineWrap(true);
        textfield.setWrapStyleWord(true);

        //Font
        Font font = new Font("Serif", Font.PLAIN, 15);
        textfield.setFont(font);
        textfield.setForeground(Color.black);
        //border
        border = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(border);
        add(textfield);
        textfield.setVisible(true);

    }

    public void mostrarMensaje(String mensaje) {
        textfield.append(mensaje+"\n");
        
       
    }
}