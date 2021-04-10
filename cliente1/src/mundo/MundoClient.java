/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import Controlador.ControladorClient;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class MundoClient implements Runnable {

    private final String ip = "127.0.0.1";
    private final int portSend = 5050;
    private final int portListen = 5000;
    private ControladorClient ctrl;
    private Thread thread;

   
    public MundoClient(ControladorClient ctrl) {
        this.ctrl = ctrl;
    }

    //Recibe mensaje.
    @Override
    public void run() {
        Socket socket;
        DataInputStream inObjectBuffer;
        ServerSocket server;
        try {

            server = new ServerSocket(portListen);
            while (true) {
                socket = server.accept();
                inObjectBuffer = new DataInputStream(socket.getInputStream());
                String msgr = inObjectBuffer.readUTF();
                //System.out.println(msgr);
                ctrl.recibirMensaje(desencriptar(msgr));
                //desencriptar(msgr);
                socket.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable ex) {
            Logger.getLogger(MundoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Envía mensaje
    public void socket(String mensaje) {
        try {

            try (Socket server = new Socket(ip, portSend)) {
                DataOutputStream outBuffer = new DataOutputStream(server.getOutputStream());
                outBuffer.writeUTF(encriptar(mensaje));
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
