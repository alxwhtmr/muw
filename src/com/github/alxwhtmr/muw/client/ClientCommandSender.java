package com.github.alxwhtmr.muw.client;

import com.github.alxwhtmr.muw.client.gui.Client;

/**
 * Created by alexbel on 17.09.2014.
 */
public class ClientCommandSender {
    private Client client;

    public ClientCommandSender(Client client) {
        this.client = client;
    }

    public void sendCommand(String msg) {
        client.getConnection().out.println(client.getClientName() + ": \"" + msg + "\"");
//        String incoming = client.getConnection().in.nextLine();
//        client.appendText(incoming);
    }

    public void sendGlobalMsg(String msg) {
        client.getConnection().out.println(client.getClientName() + ": \"" + msg + "\"");
    }
}
