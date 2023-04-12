package org.kawai.game.command;


import org.kawai.game.config.Commandable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandHolder {
    private final Map<CommandType, Commandable> commandableMap = new HashMap<>();

    public CommandHolder(List<Commandable> commandables) {
        for (Commandable commandable : commandables) {
            commandableMap.put(commandable.getCommandType(), commandable);
        }
    }

    public Map<CommandType, Commandable> getCommandableMap() {
        return commandableMap;
    }

}
