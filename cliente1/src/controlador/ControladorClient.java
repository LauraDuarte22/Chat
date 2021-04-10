/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import interfaz.PanelConversacion;
import interfaz.PanelEnviar;
import mundo.MundoClient;

/**
 *
 * @author admin
 */
public class ControladorClient {

    private MundoClient mundo;
    private PanelConversacion pnlConversacion;
    private PanelEnviar pnlEnviar;

    public ControladorClient() {
        //  this.pnlEnviar = pnlEnviar;
        mundo = new MundoClient(this);
        mundo.init();
    }

    public void conectar(PanelConversacion pnlConversacion, PanelEnviar pnlEnviar) {
        this.pnlConversacion = pnlConversacion;
        this.pnlEnviar = pnlEnviar;
        
    }
    public void recibirMensaje(String msg){
        pnlConversacion.mostrarMensaje("Server: "+msg);
    }

    public void enviarMensaje(String msg){
        mundo.socket(msg);
    }
    /*public void encriptar(String msgReceive) {
        mundo.encriptar(msgReceive);
    }

    public void desencriptar(String msgReceive) {
        pnlConversacion.mostrarMensaje(mundo.desencriptar(msgReceive));
    }
     */
}
