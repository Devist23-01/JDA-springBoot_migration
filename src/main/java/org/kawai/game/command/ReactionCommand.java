package org.kawai.game.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import org.kawai.game.config.Commandable;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDateTime;

import static org.kawai.game.utils.BotEventUtils.sendMessage;

@Component
public class ReactionCommand implements Commandable {

    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        if (userMessage.equals("센세")) {
            EmbedBuilder builder = new EmbedBuilder();

            MessageEmbed message = builder.setTitle("그림보여줄게")
                    .setDescription("이건 그림을 보여주기전 가이드")
                    .setColor(Color.BLUE)
                    .setTimestamp(LocalDateTime.now())
                    .setFooter("그림가이드", "https://avatars.githubusercontent.com/u/47031639?v=4")
                    .setAuthor("ToraMochi", "https://twitter.com/ToraMoochi", "https://avatars.githubusercontent.com/u/47031639?v=4")
                    .addField(new MessageEmbed.Field("트위터", "팔로우 부탁드립니다", true))
                    .addField(new MessageEmbed.Field("픽시브", "https://www.pixiv.net/users/90684929", false))
                    .addField(new MessageEmbed.Field("얄루", "야호", true))
                    .setImage("https://avatars.githubusercontent.com/u/47031639?v=4")
                    .build();

//            sendMessage(channel, "ToraMochi 의 그림을 보려면 n월을 입력해줘 !!");
            channel.sendMessageEmbeds(message).queue();
        }

        if (userMessage.equals("4월")) {
            sendMessage(channel, "4월은 고통입니다.");
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.REACTION;
    }

}
