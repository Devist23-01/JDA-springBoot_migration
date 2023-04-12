package org.kawai.game.command;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum CommandType {
    REACTION(""),
    RPS("도박", "ㄷㅂ", "ㄷ", "rps"),
    IMAGE("코코미", "행크TS", "이로TS"),
    STORY("나랑놀자");
    // 이 상수들은 CommandSet Array

    //    set == collection
    private final Set<String> commandSet = new HashSet<>();

    //    enum은 Runtime에서 실행함
    CommandType(String... commandSet) {
        this.commandSet.addAll(Arrays.asList(commandSet));
    }

    public static CommandType from(String command) {
        CommandType[] values = CommandType.values();
        for (CommandType value : values) {
            Set<String> commandSet = value.getCommandSet();
            for (String realCommand : commandSet) {
                if (realCommand.equals(command)) {
                    return value;
                }
            }
        }
        return REACTION;
    }

    public Set<String> getCommandSet() {
        return commandSet;
    }
}
