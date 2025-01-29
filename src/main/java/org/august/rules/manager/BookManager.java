package org.august.rules.manager;

import org.august.paper.PaperBookCreator;
import org.august.rules.dto.BookDto;
import org.august.spigot.SpigotBookCreator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BookManager {

    public static class Holder {
        public static final BookManager INSTANCE = new BookManager();
    }

    public static BookManager getInstance() {
        return Holder.INSTANCE;
    }

    public void openBook(Player player, BookDto bookDto) {
        if (Bukkit.getVersion().split("-")[1].equals("Spigot")) {
            SpigotBookCreator.getInstance().openBook(player, bookDto.getTitle(), bookDto.getAuthor(), bookDto.getRules());
        } else {
            PaperBookCreator.getInstance().openBook(player, bookDto.getTitle(), bookDto.getAuthor(), bookDto.getRules());
        }
    }

}