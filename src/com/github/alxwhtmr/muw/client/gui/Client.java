package com.github.alxwhtmr.muw.client.gui;

import com.github.alxwhtmr.muw.client.ClientCommandProcessor;
import com.github.alxwhtmr.muw.client.ClientCommandSender;
import com.github.alxwhtmr.muw.client.Connection;
import com.github.alxwhtmr.muw.common.Common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;

/**
 * Created by alexbel on 02.09.2014.
 */
public class Client extends JPanel {
    protected JFrame frame;
    protected JTextField textField;
    protected CustomTextArea1 textArea;
//    protected JEditorPane textArea;

    private ClientCommandProcessor clientCommandProcessor;
    private ClientCommandSender clientCommandSender;
    private Connection connection;
    private String clientName;

    public Client() {
        super(new GridBagLayout());
        clientName = null;
        clientCommandSender = new ClientCommandSender(this);
        connection = new Connection(this);

        clientCommandProcessor = new ClientCommandProcessor(this);
        textField = new CustomTextField(this, 20);
//        textArea = new CustomTextArea(20, 80);
        textArea = new CustomTextArea1("text/html", "");
        textArea.setText("TEXT");

        JScrollPane scrollPane = new JScrollPane(textArea);

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.weighty = 0.0;
        add(textField, c);
//        setSize(20, 80);
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public Connection getConnection() {
        return connection;
    }

    public ClientCommandProcessor getClientCommandProcessor() {
        return clientCommandProcessor;
    }

    public ClientCommandSender getClientCommandSender() {
        return clientCommandSender;
    }

//    public void appendText(String text) {
//        textArea.append('\n' + text);
//        textArea.setCaretPosition(textArea.getDocument().getLength());
//        frame.toFront();
//    }

    public void appendText(String text) {
        textArea.setText(textArea.getText() + '\n' + text);
        textArea.setCaretPosition(textArea.getDocument().getLength());
        frame.toFront();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void clear() {
        textArea.setText(connection.getConnectionLine());
    }

//    public JTextArea getTextArea() {
//        return textArea;
//    }

    private void createAndShowGUI() {
//        System.out.println(Common.getMethodName(2));
        frame = new JFrame("Client");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                textField.requestFocus();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (connection.isEstablished()) {
                    clientCommandProcessor.processCommand(Common.Constants.Service.SERVICE_SYMBOL + Common.Constants.Service.QUIT);
                }
                super.windowClosing(e);
            }
        });

        frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void connect() {
        this.getConnection().establish(Common.Constants.Misc.HOST, Common.Constants.Misc.PORT);
    }

    public static void main(String[] args) throws java.io.UnsupportedEncodingException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Client client = new Client();
                client.createAndShowGUI();
                ///////////////////////////////////
                client.connect();
                ///////////////////////////////////
            }
        });
    }
}


//        try {
//        while (client.getConnection().isEstablished() != true);
//
//        if (client.getConnection().isEstablished()) {
//            String inputLine;
//            while ((inputLine = client.getConnection().getInputStreamLine()) != null) {
//                System.out.println(inputLine);
//            }
//        }

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            while (true) {
//                Thread.sleep(300L);
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                       if (client.getConnection().isEstablished()) {
//                            System.out.println(client.getConnection().getInputStreamLine());
//                            client.appendText(client.getConnection().getInputStreamLine());
//                       }
//                    }
//                });
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//                    Client client = new Client();
//                    client.createAndShowGUI();
//                    while (true) {
//                        Thread.sleep(500L);
//                        SwingUtilities.invokeLater(new Runnable() {
//                            public void run() {
//                                client.textArea.append(Integer.toString(count++));
//                            }
//                        });
//                    }
//                try {
//                    Thread.sleep(500);
//                    client.textArea.setText(Integer.toString(count++));
//                } catch(InterruptedException e) {
//                    e.printStackTrace();
//                }
//                EventQueue.invokeLater(new Runnable(){
//                    public void run()
//                    {
//                        Client client = new Client();
//                        client.createAndShowGUI();
//                        try {
//                             for (int i = 0; i < 10; i++) {
//                                 Thread.sleep(500);
//                                 client.textArea.setText(Integer.toString(count++));
//                             }
//                        } catch(InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });

//                }
//            });
//        }
//    }
//}
