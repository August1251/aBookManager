package org.august.bookmanager.manager;

import org.august.paper.PaperBookCreator;
import org.august.bookmanager.dto.BookDto;
import org.august.bookmanager.dto.SettingsDto;
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
        SettingsDto settingsDto = bookDto.getSettingsDto();

        if (Bukkit.getVersion().split("-")[1].equals("Spigot")) {
            SpigotBookCreator.getInstance().openBook(player, bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPages(), settingsDto.isBookAutoOpen(), settingsDto.isGiveTheBookToAPlayer());
        } else {
            PaperBookCreator.getInstance().openBook(player, bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPages(), settingsDto.isBookAutoOpen(), settingsDto.isGiveTheBookToAPlayer());
        }
    }

}