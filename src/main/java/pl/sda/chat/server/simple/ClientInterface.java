package pl.sda.chat.server.simple;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientInterface implements Runnable {
    private Socket connection;
    private Scanner sc;
    private String nickname = "user";
    private List<ClientInterface> currentClientsList;

    public ClientInterface(Socket connection) throws IOException {
        this.connection = connection;
        sc = new Scanner(connection.getInputStream());
    }

    @Override
    public String toString() {
        return nickname;
    }

    public void setCurrentClientsList(List<ClientInterface> currentClientsList) {
        this.currentClientsList = currentClientsList;
    }

    public Socket getConnection(){
        return this.connection;
    }

    @Override
    public void run() {
        System.out.println("Witaj, " + nickname);
        while (sc.hasNextLine()) {
            String inputMessage = sc.nextLine();
            System.out.println(Thread.currentThread().getName() + ": " + inputMessage + Thread.currentThread().getName());
            try {
                for (ClientInterface ci:currentClientsList) {
                    ci.getConnection().getOutputStream().write(("SERWER WYSYLA DO KLIENTA: " + inputMessage + "\n").getBytes());
//                    connection.getOutputStream().write(("SERWER WYSYLA DO KLIENTA: " + inputMessage + "\n").getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}