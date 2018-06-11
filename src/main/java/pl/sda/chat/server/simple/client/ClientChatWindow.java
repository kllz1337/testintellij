package pl.sda.chat.server.simple.client;

import pl.sda.chat.server.simple.ClientUI;

import javax.swing.*;
import java.awt.*;

public class ClientChatWindow extends JFrame {
    private JTextArea inputMessagesArea = new JTextArea("area");
    private JTextField newMessageField = new JTextField("field");
    private JButton sendMessage = new JButton("Send");
    private Client client;
    private ClientUI clientUI = new ClientUI();

    public ClientChatWindow(Client client) throws HeadlessException {
        this.client = client;
        setLayout(new BorderLayout());
        add(inputMessagesArea, BorderLayout.PAGE_START);
        inputMessagesArea.setRows(26);
        inputMessagesArea.setEditable(false);
        add(newMessageField, BorderLayout.LINE_START);
        Dimension dim = new Dimension();
        dim.width = 500;
        newMessageField.setPreferredSize(dim);
        add(sendMessage, BorderLayout.AFTER_LAST_LINE);
        sendMessage.addActionListener(e -> {
                        System.out.println(client.getNickname() + ": " + newMessageField.getText());    // PRZEKAZAC TO DO STREAMA
                        newMessageField.setText("");
        });
        getRootPane().setDefaultButton(sendMessage);

        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
