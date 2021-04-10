/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import controlador.ControladorServer;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class MundoServer implements Runnable {

    private ControladorServer ctrl;
    private Thread thread;

    private final String ip = "127.0.0.1";
    private final int PORTSEND = 5000;
    private final int PORTLISTEN = 5050;

     private final char[] EN = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
        '5', '6', '7', '9', '-'};

    private final char[] DES = {'d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
        '2', '3', '4', '5', '6', '7', '9', '-', 'a', 'b', 'c',};

    public MundoServer(ControladorServer ctrl) {
        this.ctrl = ctrl;
    }

    //Recibe mensaje.
    @Override
    public void run() {
        Socket socket;
        DataInputStream inObjectBuffer;
        ServerSocket server;
       
        try {

            server = new ServerSocket(PORTLISTEN);
            while (true) {
                socket = server.accept();
                inObjectBuffer = new DataInputStream(socket.getInputStream());
                String msgr = inObjectBuffer.readUTF();
                
                ctrl.toReceive(msgr);
                socket("he");
                socket.close();
                // System.exit(0);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable ex) {
            Logger.getLogger(MundoServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Envía mensaje
    private void socket(String msg) {
        try {

            try (Socket server = new Socket(ip, PORTSEND)) {
                DataOutputStream outBuffer = new DataOutputStream(server.getOutputStream());
                outBuffer.writeUTF(msg);
                server.close();
            }
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "socket() : UnknownHostException: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "socket() : IOException: " + e.getMessage());
        }
    }

    public void init() {
        thread = new Thread(this);
        thread.start();
    }
    
    public void encriptar(String msg) {
        String encriptado = "";
        int cont = 0;
        int i = 0;
        while (cont < msg.length()) {
            if (msg.charAt(cont)==EN[i]) {
                encriptado += DES[i];

                cont++;
                i = -1;
            }
            i++;

        }
        socket(encriptado);
    }

    public String desencriptar(String msg) {
        String encriptado = "";
        int cont = 0;
        int i = 0;
        while (cont < msg.length()) {
            if (msg.charAt(cont) == EN[i]) {
                encriptado += DES[i];
                cont++;
                i = -1;
            }
            i++;

        }
        return encriptado;
    }
}

