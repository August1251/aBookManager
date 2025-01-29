package org.august.spigot;

import org.august.core.MessageHandler;
import org.august.spigot.format.ColorFormatter;
import org.bukkit.entity.Player;

public class SpigotMessageSender implements MessageHandler {

    public static class Holder {
        public static final SpigotMessageSender INSTANCE = new SpigotMessageSender();
    }

    public static SpigotMessageSender getInstance() {
        return Holder.INSTANCE;
    }

    private final ColorFormatter colorFormatter = ColorFormatter.getInstance();

    @Override
    public void sendMessage(String message, Player player) {
        player.sendMessage(colorFormatter.getColoredText(message));
    }

}