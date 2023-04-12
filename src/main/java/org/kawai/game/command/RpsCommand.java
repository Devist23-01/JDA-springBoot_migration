package org.kawai.game.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.kawai.game.config.Commandable;
import org.springframework.stereotype.Component;

@Component
public class RpsCommand implements Commandable {
    @Override
    public void doCommand(MessageChannel channel, User user, String message) {


        int percentage = (int) (Math.random() * 3);
        int computer;

        if (percentage == 0) {
            computer = 0;
        } else if (percentage == 1) {
            computer = 1;
        } else {
            computer = 2;
        }

        if (message.equals("가위")) {
            if (computer == 0) {
                channel.sendMessage("비겼습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("졌습니다!").queue();
            } else {
                channel.sendMessage("이겼습니다!").queue();
            }
        } else if (message.equals("바위")) {
            if (computer == 0) {
                channel.sendMessage("이겼습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("비겼습니다!").queue();
            } else {
                channel.sendMessage("졌습니다!").queue();
            }
        } else if (message.equals("보")) {
            if (computer == 0) {
                channel.sendMessage("졌습니다!").queue();
            } else if (computer == 1) {
                channel.sendMessage("이겼습니다!").queue();
            } else {
                channel.sendMessage("비겼습니다!").queue();
            }
        } else {
            channel.sendMessage("모르겠습니다").queue();
        }

    }

    @Override
    public CommandType getCommandType() {
        return CommandType.RPS;
    }
}
