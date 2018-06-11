package pl.sda.chat.server.simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        List<ClientInterface> currentClientsList = new ArrayList<>();

        while (true) {
            Socket newConnection = serverSocket.accept();
            ClientInterface clientInterface = new ClientInterface(newConnection);
            currentClientsList.add(clientInterface);
            for (ClientInterface currentClient : currentClientsList) {
                currentClient.setCurrentClientsList(currentClientsList);
            }
            Thread newThread = new Thread(clientInterface);
            newThread.start();
        }
    }
}