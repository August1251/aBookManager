package org.august.bookmanager.manager;

import me.clip.placeholderapi.PlaceholderAPI;
import org.august.paper.PaperMessageSender;
import org.august.bookmanager.aBookManager;
import org.august.bookmanager.dto.MessageDto;
import org.august.spigot.SpigotMessageSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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

    public void sendMessage(MessageDto messageDto, Player player) {
        if (!messageDto.isEnabled()) return;
        if (Bukkit.getVersion().split("-")[1].equals("Spigot")) {
            for (String message : messageDto.getMessage()) {
                SpigotMessageSender.getInstance().sendMessage(message, player);
                System.out.println(getPlaceholderText(message, player));
            }
        } else {
            for (String message : messageDto.getMessage()) {
                PaperMessageSender.getInstance().sendMessage(message, player);
                System.out.println(getPlaceholderText(message, player));
            }
        }
    }

    private String getPlaceholderText(String message, Player player) {
        if (bookManager.getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) return message;
        return PlaceholderAPI.setPlaceholders(player, message);
    }

    public static void setBookManager(aBookManager bookManager) {
        MessageManager.bookManager = bookManager;
    }

}