package pl.sda.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientGUIMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client("imie ze swinga",InetAddress.getLocalHost().getAddress().toString());
        InetAddress chatServerAddress = InetAddress.getByName("adres ze swinga");
        Integer chatServerPort = Integer.valueOf("port ze swinga");
        Socket chatServer = new Socket(chatServerAddress, chatServerPort);

        InputStream serverInputStream = chatServer.getInputStream();
        OutputStream serverOutputStream = chatServer.getOutputStream();

        Scanner sc = new Scanner(serverInputStream);  // SKANER ustawiony na INPUT Z SERWERA

//        ObjectOutputStream clientOutput = new ObjectOutputStream(serverOutputStream);
//        clientOutput.write();
        serverOutputStream.write(("KLIENT DO SERWERA: witam witam witam\n").getBytes());  // STREAM OD KLIENTA DO SERWERA
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println("Z SERWERA U KLIENTA: " + s);
//            chatServer.getOutputStream().write(("KLIENT DO SERWERA: Jestem na wątku\n").getBytes());
            Thread.sleep(2000);
        }
    }
}
