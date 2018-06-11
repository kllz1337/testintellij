package pl.sda.chat.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientInterface implements Runnable {
    private Socket connection;
    private Scanner sc;
    private String nickname = "user";
    private String inputMessage = "input message";
    private String outputMessage = "output message";

    public ClientInterface(Socket connection) throws IOException {
        this.connection = connection;
        sc = new Scanner(connection.getInputStream());
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public void run() {
        System.out.println("Witaj, " + nickname);
        while (sc.hasNextLine()) {
            String inputMessage = sc.nextLine();
            System.out.println("SERWER DOSTAJE OD KLIENTA " + nickname + ": " + inputMessage + Thread.currentThread().getName());
            try {
                connection.getOutputStream().write(("SERWER WYSYLA DO KLIENTA: " + inputMessage + "\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}