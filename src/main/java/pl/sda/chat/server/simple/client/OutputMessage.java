package pl.sda.chat.server.simple.client;

public class OutputMessage {
    private Client client;
    private String textMessage;

    public OutputMessage(Client client, String message) {
        this.client = client;
        this.textMessage = textMessage;
    }

//    @Override
//    public String toString() {
//        return client.getNickname() + ": " + message;
//    }
}
