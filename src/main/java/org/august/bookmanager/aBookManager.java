package org.august.bookmanager;

import org.august.bookmanager.command.BaseCommand;
import org.august.bookmanager.config.CommandsConfiguration;
import org.august.bookmanager.config.MessagesConfiguration;
import org.august.bookmanager.config.BooksConfiguration;
import org.august.bookmanager.config.SettingsConfiguration;
import org.august.bookmanager.dto.CommandDto;
import org.august.bookmanager.manager.MessageManager;
import org.august.bookmanager.utility.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class aBookManager extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        configure();
        registerCommands();

        Metrics metrics = new Metrics(this, 24656);
    }

    private void configure() {
        CommandsConfiguration.getInstance().setBookManager(this);
        MessagesConfiguration.getInstance().setBookManager(this);
        SettingsConfiguration.getInstance().setBookManager(this);
        BooksConfiguration.getInstance().setBookManager(this);
        MessageManager.setBookManager(this);
    }

    private void registerCommands() {
        BooksConfiguration booksConfiguration = BooksConfiguration.getInstance();
        for (String bookId : booksConfiguration.getBooks()) {
            CommandDto commandDto = booksConfiguration.getBook(bookId).getCommandDto();

            try {
                Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

                bukkitCommandMap.setAccessible(true);

                CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

                commandMap.register(bookId, "aBookManager", new BaseCommand(bookId, commandDto.getDescription(), commandDto.getUsageMessage(), commandDto.getAliases()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}