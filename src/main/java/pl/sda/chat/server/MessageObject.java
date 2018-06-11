package pl.sda.chat.server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageObject implements IMessageObject {
    private Client client;
    private LocalDateTime localDateTime;
    private String message;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");



    @Override
    public String toString() {
        return getTime(localDateTime) + " " + client.getNickname() + ": " + message;
    }

    public String getTime(LocalDateTime localDateTime){
        return localDateTime.format(dtf);
    }
}
