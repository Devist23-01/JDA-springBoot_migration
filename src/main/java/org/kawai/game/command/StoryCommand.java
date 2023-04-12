package org.kawai.game.command;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import org.kawai.game.command.scenario.HelloScenario;
import org.kawai.game.command.scenario.Scenario;
import org.kawai.game.config.Commandable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class StoryCommand implements Commandable {
    private List<Scenario> stages = new ArrayList<>();
    // userId -> stage index

    // 사용자가 몇번째 시나리오까지 진행했는지 기억함
    private Map<String, Integer> userStageMap = new HashMap<>();


    public StoryCommand() {
        stages.add(new HelloScenario());
    }

    @Override
    public void doCommand(MessageChannel channel, User user, String userMessage) {
        String userId = user.getId();
        Integer choice = null;
        try {
            choice = Integer.parseInt(userMessage);
        } catch (NumberFormatException e) {
            userStageMap.put(userId, 0);
            stages.get(0).runScenario(channel, user, choice);
//            channel.sendMessage("선택지에 대한 숫자를 입력해주세요.").queue();
            return;
        }
        if (userStageMap.containsKey(userId)) {
            Scenario scenario = stages.get(userStageMap.get(userId));
            scenario.runScenario(channel, user, choice);
            if (scenario.completeFinalStep()) {
                Integer stageLevel = userStageMap.get(userId);
                userStageMap.put(userId, stageLevel + 1);
            }
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.STORY;
    }
}
