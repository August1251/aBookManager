package org.august.rules.config;

import org.august.rules.aRules;
import org.august.rules.dto.MessageDto;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class MessagesConfiguration {

    public static class Holder {
        public static final MessagesConfiguration INSTANCE = new MessagesConfiguration();
    }

    public static MessagesConfiguration getInstance() {
        return Holder.INSTANCE;
    }

    private static aRules rules;

    public FileConfiguration getConfig() {
        return rules.getConfig();
    }

    public ConfigurationSection getMessages() {
        return getConfig().getConfigurationSection("messages");
    }

    public MessageDto getMessage(String index) {
        ConfigurationSection messageSection = getMessages().getConfigurationSection(index);

        boolean enabled = messageSection.getBoolean("enabled");
        List<String> message = messageSection.getStringList("message");

        return new MessageDto(enabled, message);
    }

    public static void setRules(aRules rules) {
        MessagesConfiguration.rules = rules;
    }

}