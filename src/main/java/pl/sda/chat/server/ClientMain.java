package pl.sda.chat.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket chatServer = new Socket(InetAddress.getLocalHost(), 8888);
        Scanner sc = new Scanner(chatServer.getInputStream());

        chatServer.getOutputStream().write(("Hello, " + "imie").getBytes());
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println("Server sent: " + s);
            chatServer.getOutputStream().write(("Test cd\n").getBytes());
            Thread.sleep(1000);
        }

    }
}
