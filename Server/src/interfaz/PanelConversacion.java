/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.*;
import javax.swing.*;
import controlador.ControladorServer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author admin
 */
public class PanelConversacion extends JPanel {

    private JTextArea textfield;
    private Border border;
    private ControladorServer ctrl;

    public PanelConversacion(ControladorServer ctrl) {
        this.ctrl = ctrl;
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        textfield = new JTextArea();;
        textfield.setEnabled(false);
        textfield.setBounds(1, 20, 240, 260);
        textfield.setForeground(Color.RED);

        //Font
        Font font = new Font("Serif", Font.PLAIN, 15);

        border = BorderFactory.createTitledBorder(border, "Convesación encriptada", TitledBorder.CENTER, 
                TitledBorder.BELOW_TOP, font, Color.BLACK);

        setBorder(border);
        add(textfield);
        textfield.setVisible(true);

    }

    public void mostrarMensaje(String mensaje) {
        textfield.append(mensaje + "\n");

    }
}
