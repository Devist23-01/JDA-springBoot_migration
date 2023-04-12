package org.kawai.game.command.scenario;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public interface Scenario {

    // 1.상대가 채팅을 친다.
    // 2.내가 선택지를 고른다.
    // 3.출력이 나온다.
    boolean unCompleteFirstStep();

    boolean completeFirstStep();

    boolean completeSecondStep();

    boolean completeFinalStep();

    void printPredefinedText(MessageChannel channel, User user, Integer choice);

    void chose(MessageChannel channel, User user, Integer choice);

    void printPostDefinedText(MessageChannel channel, User user, Integer choice);

    default void runScenario(MessageChannel channel, User user, Integer choice) {
        // 구현은 책임지지 않지만 이 커맨드 순서를 보장하는 커맨드패턴
        if (unCompleteFirstStep()) {
            printPredefinedText(channel, user, choice);
        }
        if (completeFirstStep() && choice != null) {
            chose(channel, user, choice);
        }
        if (completeSecondStep()) {
            printPostDefinedText(channel, user, choice);
        }
    }
}
