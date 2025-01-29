package org.august.paper.format;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ComponentFormatter {

    public static class Holder {
        public static final ComponentFormatter INSTANCE = new ComponentFormatter();
    }

    public static ComponentFormatter getInstance() {
        return Holder.INSTANCE;
    }

    public Component getComponentizedText(String text) {
        return MiniMessage.miniMessage().deserialize(text);
    }

}