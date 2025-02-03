package org.august.bookmanager.config;

import org.august.bookmanager.aBookManager;
import org.august.bookmanager.dto.CommandDto;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class CommandsConfiguration {

    public static class Holder {
        public static final CommandsConfiguration INSTANCE = new CommandsConfiguration();
    }

    public static CommandsConfiguration getInstance() {
        return Holder.INSTANCE;
    }

    private static aBookManager bookManager;

    public FileConfiguration getConfig() {
        return bookManager.getConfig();
    }

    public ConfigurationSection getCommandSection(String bookId) {
        return getConfig().getConfigurationSection(bookId);
    }

    public CommandDto getCommand(String bookId) {
        ConfigurationSection commandSection = getCommandSection(bookId);

        String description = commandSection.getString("description");
        String usage = commandSection.getString("usage");
        List<String> aliases = commandSection.getStringList("aliases");

        return new CommandDto(description, usage, aliases);
    }


    public void setBookManager(aBookManager bookManager) {
        CommandsConfiguration.bookManager = bookManager;
    }

}