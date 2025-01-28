package org.august.rules.manager;

import org.august.rules.aRules;
import org.august.rules.dto.MessageDto;
import org.august.rules.format.ColorFormatter;
import org.bukkit.entity.Player;

public class MessageManager {

    private final ColorFormatter colorFormatter = ColorFormatter.getInstance();

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
            rules.getLogger().warning(colorFormatter.getFormattedColor(message));
        }
    }

    public void sendMessage(MessageDto messageDto, Player player) {
        if (!messageDto.isEnabled()) return;
        for (String message : messageDto.getMessage()) {
            player.sendMessage(colorFormatter.getFormattedColor(message));
        }
    }

    public static void setRules(aRules rules) {
        MessageManager.rules = rules;
    }

}