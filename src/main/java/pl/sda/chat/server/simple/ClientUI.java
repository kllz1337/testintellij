package pl.sda.chat.server.simple;

import pl.sda.chat.server.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientUI {
    public static void main(String[] args) throws IOException, InterruptedException {
        String nickname = "imie ze swinga";
        InetAddress chatServerAddress = InetAddress.getByName("localhost");   // adres ze swinga
        Integer chatServerPort = Integer.valueOf("8888"); // port ze swinga
        Socket chatServer = new Socket(chatServerAddress, chatServerPort);  // USTANOWIENIE SERWERA

        InputStream serverInputStream = chatServer.getInputStream();    // USTANOWIENIE STREAMU PRZYCHODZACEGO Z SERWERA
        OutputStream serverOutputStream = chatServer.getOutputStream(); // USTANOWIENIE STREAMU WYCHODZACEGO DO SERWERA

        Scanner sc = new Scanner(serverInputStream);  // SKANER ustawiony na INPUT Z SERWERA
        Scanner sc1 = new Scanner(System.in);

        serverOutputStream.write((nickname + ", witam!\n").getBytes());

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(s);
            String messageToSend = sc1.nextLine();
            serverOutputStream.write((nickname + ": " + messageToSend + "\n").getBytes());
        }
    }
}
