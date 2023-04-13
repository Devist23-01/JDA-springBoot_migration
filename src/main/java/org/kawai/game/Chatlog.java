package org.kawai.game;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class Chatlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String  userId;

    private String rawMessage;

    private LocalDateTime receiveDataTime;

    public static Chatlog create(String username, String userId, String rawMessage, LocalDateTime receiveDataTime){
        Chatlog chatlog = new Chatlog();
        chatlog.username = username;
        chatlog.userId = userId;
        chatlog.rawMessage = rawMessage;
        chatlog.receiveDataTime = receiveDataTime;
        return chatlog;
    }
}
