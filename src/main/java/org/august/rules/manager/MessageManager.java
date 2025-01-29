package org.august.rules.manager;

import org.august.paper.PaperMessageSender;
import org.august.rules.aRules;
import org.august.rules.dto.MessageDto;
import org.august.spigot.SpigotMessageSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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
        if (Bukkit.getVersion().split("-")[1].equals("Spigot")) {
            for (String message : messageDto.getMessage()) {
                SpigotMessageSender.getInstance().sendMessage(message, player);
            }
        } else {
            for (String message : messageDto.getMessage()) {
                PaperMessageSender.getInstance().sendMessage(message, player);
            }
        }
    }

    public static void setRules(aRules rules) {
        MessageManager.rules = rules;
    }

}