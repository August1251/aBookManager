package org.august.rules.manager;

import org.august.rules.aRules;
import org.august.rules.dto.MessageDto;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageManager {

    public static class Holder {
        public static final MessageManager INSTANCE = new MessageManager();
    }

    public static MessageManager getInstance() {
        return Holder.INSTANCE;
    }

    private static aRules rules;

    public void sendMessage(MessageDto messageDto) {
        if (!messageDto.isEnabled()) return;
        for (String message : messageDto.getMessage()) {
            rules.getLogger().warning(message);
        }
    }

    public void sendMessage(MessageDto messageDto, Player player) {
        if (!messageDto.isEnabled()) return;
        for (String message : messageDto.getMessage()) {
            player.sendMessage(message);
        }
    }

    public static void setRules(aRules rules) {
        MessageManager.rules = rules;
    }

}