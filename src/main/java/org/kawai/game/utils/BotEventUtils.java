package org.kawai.game.utils;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BotEventUtils {
    public static boolean isBot(MessageReceivedEvent event) {
        return event.getAuthor().isBot();
    }

    public static void sendMessage(MessageChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
