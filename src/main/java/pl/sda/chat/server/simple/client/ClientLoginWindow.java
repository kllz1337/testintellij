package pl.sda.chat.server.simple.client;

import javax.swing.*;
import java.awt.*;
import java.net.UnknownHostException;

public class ClientLoginWindow extends JFrame {
    private JLabel loginLabel = new JLabel("Nick:");
    private JTextField loginField = new JTextField();
    private JButton loginButton = new JButton("Log in");

    public ClientLoginWindow() throws HeadlessException {
        setLayout(new BorderLayout());
        setTitle("Log in");
        setSize(300,90);
        loginField.setPreferredSize(new Dimension(150,20));
        JPanel loginPanel = new JPanel();
        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        add(loginPanel,BorderLayout.NORTH);
        add(loginButton, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(loginButton);
        loginButton.addActionListener(e -> {
            Client client = null;
            try {
                client = new Client(loginField.getText());
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            }
            ClientChatWindow clientChatWindow = new ClientChatWindow(client);
            clientChatWindow.setVisible(true);
            this.setVisible(false);
        });
    }
}
