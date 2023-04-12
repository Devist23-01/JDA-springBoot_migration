package org.kawai.game.command.scenario;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.time.LocalDateTime;

public class ScenarioMessageDirector {
    public static MessageEmbed emotionMessage(String imgUrl, String title) {
        EmbedBuilder builder = new EmbedBuilder();
        return builder.setColor(Color.BLUE)
                .addField(new MessageEmbed.Field("코하루 :", title, true))
                .setTimestamp(LocalDateTime.now())
                .setImage(imgUrl)
                .build();
    }
}
