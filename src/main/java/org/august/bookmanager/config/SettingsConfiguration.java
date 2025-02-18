package org.august.bookmanager.config;

import org.august.bookmanager.aBookManager;
import org.august.bookmanager.dto.SettingsDto;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class SettingsConfiguration {

    public static class Holder {
        public static final SettingsConfiguration INSTANCE = new SettingsConfiguration();
    }

    public static SettingsConfiguration getInstance() {
        return Holder.INSTANCE;
    }

    private static aBookManager bookManager;

    public FileConfiguration getConfig() {
        return bookManager.getConfig();
    }

    public ConfigurationSection getSettingsSection(String bookId) {
        return getConfig().getConfigurationSection(bookId).getConfigurationSection("settings");
    }

    public SettingsDto getSettings(String bookId) {
        ConfigurationSection settingsSection = getSettingsSection(bookId);

        boolean bookAutoOpen = settingsSection.getBoolean("book-auto-open");
        boolean giveTheBookToAPlayer = settingsSection.getBoolean("give-the-book-to-a-player");
        boolean cancelTheIssueIfTheInventoryIsFull = settingsSection.getBoolean("cancel-the-issue-if-the-inventory-is-full");
        boolean dropTheBookIfTheInventoryIsFull = settingsSection.getBoolean("drop-the-book-if-the-inventory-is-full");

        return new SettingsDto(bookAutoOpen, giveTheBookToAPlayer, cancelTheIssueIfTheInventoryIsFull, dropTheBookIfTheInventoryIsFull);
    }

    public void setBookManager(aBookManager bookManager) {
        SettingsConfiguration.bookManager = bookManager;
    }

}