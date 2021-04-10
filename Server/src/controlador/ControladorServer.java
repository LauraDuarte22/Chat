/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaz.PanelConversacion;
import mundo.MundoServer;

/**
 *
 * @author admin
 */
public class ControladorServer {

    private MundoServer mundo;
    private PanelConversacion pnlConversacion;
 

    public ControladorServer() {
        //  this.pnlEnviar = pnlEnviar;
         mundo = new MundoServer(this);
         mundo.init();
    }

    public void conectar(PanelConversacion pnlConversacion) {
        this.pnlConversacion = pnlConversacion;
    }

    public void toReceive(String msgReceive) {
        pnlConversacion.mostrarMensaje(msgReceive);
    }
}
