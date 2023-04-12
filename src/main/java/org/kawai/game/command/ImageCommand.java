package org.kawai.game.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.kawai.game.config.Commandable;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class ImageCommand implements Commandable {
    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        try {
            File file = ResourceUtils.getFile("classPath:cocomi.png");
            channel.sendFile(Files.readAllBytes(file.toPath()), "cocomi.png").queue();
        } catch (IOException e) {
            System.out.println("파일이 없네");
            throw new RuntimeException(e);
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.IMAGE;
    }
}