package org.august.bookmanager.config;

import org.august.bookmanager.aBookManager;
import org.august.bookmanager.dto.BookDto;
import org.august.bookmanager.dto.CommandDto;
import org.august.bookmanager.dto.SettingsDto;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BooksConfiguration {

    public static class Holder {
        public static final BooksConfiguration INSTANCE = new BooksConfiguration();
    }

    public static BooksConfiguration getInstance() {
        return Holder.INSTANCE;
    }

    private final CommandsConfiguration commandsConfiguration = CommandsConfiguration.getInstance();
    private final SettingsConfiguration settingsConfiguration = SettingsConfiguration.getInstance();
    private final MessagesConfiguration messagesConfiguration = MessagesConfiguration.getInstance();
    private static aBookManager bookManager;

    public FileConfiguration getConfig() {
        return bookManager.getConfig();
    }

    public ConfigurationSection getBookSection(String bookId) {
        return getConfig().getConfigurationSection(bookId);
    }

    public Set<String> getBooks() {
        return getConfig().getKeys(false);
    }

    public BookDto getBook(String bookId) {
        ConfigurationSection bookSection = getBookSection(bookId);

        String title = bookSection.getString("title");
        String author = bookSection.getString("author");

        CommandDto commandDto = commandsConfiguration.getCommand(bookId);
        SettingsDto settingsDto = settingsConfiguration.getSettings(bookId);
        List<String> pages = new ArrayList<>();

        for (String page : getPagesSection(bookId).getKeys(false)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String i : getPage(bookId, page)) {
                stringBuilder.append(i);
                stringBuilder.append("\n");
            }
            pages.add(stringBuilder.toString());
        }

        return new BookDto(bookId, title, author, pages, commandDto, settingsDto, messagesConfiguration.getMessages(bookId));

    }

    public ConfigurationSection getPagesSection(String bookId) {
        return getConfig().getConfigurationSection(bookId).getConfigurationSection("pages");
    }

    public List<String> getPage(String bookId, String page) {
        return getPagesSection(bookId).getStringList(page);
    }

    public void setBookManager(aBookManager bookManager) {
        BooksConfiguration.bookManager = bookManager;
    }

}