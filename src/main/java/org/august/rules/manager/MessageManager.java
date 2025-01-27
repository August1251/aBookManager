package org.august.rules.manager;

import org.august.rules.aRules;
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

    public void sendMessage(List<String> messages) {
        for (String message : messages) {
            rules.getLogger().warning(message);
        }
    }

    public void sendMessage(List<String> messages, Player player) {
        for (String message : messages) {
            player.sendMessage(message);
        }
    }

    public static void setRules(aRules rules) {
        MessageManager.rules = rules;
    }

}