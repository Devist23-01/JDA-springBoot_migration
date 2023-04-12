package org.kawai.game.command.scenario;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;

import static org.kawai.game.command.scenario.ScenarioMessageDirector.emotionMessage;


public class HelloScenario implements Scenario {
    private int choice = 0;
    private int scenarioStep = 0;

    @Override
    public boolean unCompleteFirstStep() {
        return scenarioStep == 0;
    }

    @Override
    public boolean completeFirstStep() {
        return scenarioStep == 1;
    }

    @Override
    public boolean completeSecondStep() {
        return scenarioStep == 2;
    }

    @Override
    public boolean completeFinalStep() {
        return scenarioStep == 3;
    }

    @Override
    public void printPredefinedText(MessageChannel channel, User user, Integer choice) {
        channel.sendMessage(
                "향기가 나는 그녀다. \n" +
                        " [1] 안녕? " +
                        "\n[2] 사랑해").queue();
        scenarioStep++;
    }

    @Override
    public void chose(MessageChannel channel, User user, Integer choice) {
        switch (choice) {
            case 1:
                this.choice = 1;
                break;
            case 2:
                this.choice = 2;
                break;
        }
        scenarioStep++;
    }

    @Override
    public void printPostDefinedText(MessageChannel channel, User user, Integer choice) {
        switch (this.choice) {
            case 1:
                MessageEmbed emotionCase1 = emotionMessage("https://i.imgur.com/uiABZ8U.jpeg", "아..안녕, 좋은아침");
                channel.sendMessageEmbeds(emotionCase1).queue();
                break;
            case 2:
                MessageEmbed emotionCase2 = emotionMessage("https://i.pinimg.com/564x/02/93/a8/0293a8754ab844d7b6400d703b0082d8.jpg", "무.. 무슨말을하는거야 !? 바보같아");
                channel.sendMessageEmbeds(emotionCase2).queue();
                break;
        }
        scenarioStep++;
    }
}
