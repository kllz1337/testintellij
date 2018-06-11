package pl.sda.chat.server.simple.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    private String nickname;
    private String id;

    public Client(String nickname) throws UnknownHostException {
        this.nickname = nickname;
        this.id = InetAddress.getLocalHost().getAddress().toString();
    }

    public String getNickname() {
        return nickname;
    }

    public String getId() {
        return id;
    }
}
