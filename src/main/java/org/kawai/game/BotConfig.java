package org.kawai.game;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.kawai.game.handler.MessageReceiveHandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;

@Configuration
public class BotConfig {

    private final String botKey;

    public BotConfig(@Value("${app.bot_key}") String botKey, MessageReceiveHandler messageReceiveHandler) {
        this.botKey = botKey;
        this.messageReceiveHandler = messageReceiveHandler;
    }

    private final MessageReceiveHandler messageReceiveHandler;
    @PostConstruct
    public void init(){
        try {
            JDABuilder.createDefault(botKey)
            .addEventListeners(messageReceiveHandler)
            .enableIntents(GatewayIntent.GUILD_MESSAGES)
            .setActivity(Activity.watching("MIKA"))
            .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
