package pl.sda.chat.server;

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
            System.out.println(currentClientsList);
            Thread newThread = new Thread(clientInterface);
            newThread.start();
        }
    }

    public static void sendToAll(String message){

    }
}
//        if(connection.isConnected()){
//            System.out.println("polaczony");
//        }

//        if(true) {
//            IMessageObject inputMessageObject = new InputMessageObject();
//            // to w while - jeżeli więcej niż jeden klient i potem każdy klient w oddzielnym wątku powinien pisać
//
//            Scanner scanner = new Scanner(connection.getInputStream());
//
//            while (scanner.hasNextLine()) {
//                String s = scanner.nextLine();
//                System.out.println("Client sent: " + s);
//                connection.getOutputStream().write(("Bu" + s + "\n").getBytes());
//            }

//sc = new Scanner(newConnection.getInputStream());
//        while (sc.hasNextLine()) {
//        String s = sc.nextLine();
//        System.out.println("Client sent: " + s + Thread.currentThread());
//        newConnection.getOutputStream().write(("Bu" + s + "\n").getBytes());
//        }