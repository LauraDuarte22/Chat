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
                socket(msgr);
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

    public String encriptar(String msg) {
        String encriptado = "";
        for(char ch:msg.toCharArray()){
            encriptado += (char)(ch+3);
        }
        return encriptado;
    }

    public String desencriptar(String msg) {
        String desencriptado = "";
        for(char ch:msg.toCharArray()){
            desencriptado += (char)(ch-3);
        }
        return desencriptado;
    }
}
