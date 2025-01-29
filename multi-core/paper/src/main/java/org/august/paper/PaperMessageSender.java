package org.august.paper;

import org.august.core.MessageHandler;
import org.august.paper.format.ComponentFormatter;
import org.bukkit.entity.Player;

public class PaperMessageSender implements MessageHandler {

    public static class Holder {
        public static final PaperMessageSender INSTANCE = new PaperMessageSender();
    }

    public static PaperMessageSender getInstance() {
        return Holder.INSTANCE;
    }

    private final ComponentFormatter componentFormatter = ComponentFormatter.getInstance();

    @Override
    public void sendMessage(String message, Player player) {
        player.sendMessage(componentFormatter.getComponentizedText(message));
    }

}