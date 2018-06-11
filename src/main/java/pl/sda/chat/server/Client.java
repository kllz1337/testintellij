package pl.sda.chat.server;

import java.io.Serializable;

public class Client implements Serializable {
    private String nickname;
    private String id;

    public Client(String nickname, String id) {
        this.nickname = nickname;
        this.id = id;
    }

    @Override
    public String toString() {
        return nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getId() {
        return id;
    }
}
