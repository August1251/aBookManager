package org.august.bookmanager.manager;

import me.clip.placeholderapi.PlaceholderAPI;
import org.august.bookmanager.config.BooksConfiguration;
import org.august.bookmanager.dto.BookDto;
import org.august.paper.PaperMessageSender;
import org.august.bookmanager.aBookManager;
import org.august.bookmanager.dto.MessageDto;
import org.august.spigot.SpigotMessageSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MessageManager {

    public static class Holder {
        public static final MessageManager INSTANCE = new MessageManager();
    }

    public static MessageManager getInstance() {
        return Holder.INSTANCE;
    }

    private static aBookManager bookManager;

    public void sendMessage(MessageDto messageDto) {
        if (!messageDto.isEnabled()) return;
        for (String message : messageDto.getMessage()) {
            bookManager.getLogger().warning(message);
        }
    }

    public void sendMessage(MessageDto messageDto, Player player, String... strings) {
        if (!messageDto.isEnabled()) return;
        if (Bukkit.getVersion().split("-")[1].equals("Spigot")) {
            for (String message : getFormattedMessage(messageDto, strings)) {
                SpigotMessageSender.getInstance().sendMessage(message, player);
            }
        } else {
            for (String message : getFormattedMessage(messageDto, strings)) {
                PaperMessageSender.getInstance().sendMessage(message, player);
            }
        }
    }

    private List<String> getFormattedMessage(MessageDto messageDto, String... strings) {
        BooksConfiguration booksConfiguration = BooksConfiguration.getInstance();
        BookDto bookDto = booksConfiguration.getBook(messageDto.getBookId());
        List<String> messages = new ArrayList<>();

        for (String message : messageDto.getMessage()) {
            if (strings.length != 0) {
                messages.add(message.replaceAll("%cooldown%", strings[0]));
                continue;
            }
            messages.add(message);
        }

        return messages;
    }

    private String getPlaceholderText(String message, Player player) {
        if (bookManager.getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) return message;
        return PlaceholderAPI.setPlaceholders(player, message);
    }

    public static void setBookManager(aBookManager bookManager) {
        MessageManager.bookManager = bookManager;
    }

}