package org.august.rules.manager;

import org.august.rules.config.RulesConfiguration;
import org.august.rules.dto.BookDto;
import org.august.rules.format.ColorFormatter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private final RulesConfiguration rulesConfiguration = RulesConfiguration.getInstance();
    private final ColorFormatter colorFormatter = ColorFormatter.getInstance();

    public static class Holder {
        public static final BookManager INSTANCE = new BookManager();
    }

    public static BookManager getInstance() {
        return Holder.INSTANCE;
    }

    public void openBook(Player player) {
        BookDto bookDto = rulesConfiguration.getBook();

        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta itemMeta = (BookMeta) book.getItemMeta();

        itemMeta.setTitle(bookDto.getTitle());
        itemMeta.setAuthor(bookDto.getAuthor());
        itemMeta.setPages(bookDto.getRules());

        book.setItemMeta(itemMeta);

        player.openBook(book);
    }

}