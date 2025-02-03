package org.august.bookmanager.config;

import org.august.bookmanager.aBookManager;
import org.august.bookmanager.dto.MessageDto;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MessagesConfiguration {

    public static class Holder {
        public static final MessagesConfiguration INSTANCE = new MessagesConfiguration();
    }

    public static MessagesConfiguration getInstance() {
        return Holder.INSTANCE;
    }

    private static aBookManager bookManager;

    public FileConfiguration getConfig() {
        return bookManager.getConfig();
    }

    public ConfigurationSection getMessagesSection(String bookId) {
        return getConfig().getConfigurationSection(bookId).getConfigurationSection("messages");
    }

    public MessageDto getMessage(String bookId, String messageId) {
        ConfigurationSection messageSection = getMessagesSection(bookId).getConfigurationSection(messageId);

        boolean enabled = messageSection.getBoolean("enabled");
        List<String> message = messageSection.getStringList("message");

        return new MessageDto(messageId, enabled, message);
    }

    public List<MessageDto> getMessages(String bookId) {
        List<MessageDto> messages = new ArrayList<>();

        for (String message : getMessagesSection(bookId).getKeys(false)) {
            messages.add(getMessage(bookId, message));
        }

        return messages;
    }

    public void setBookManager(aBookManager bookManager) {
        MessagesConfiguration.bookManager = bookManager;
    }

}