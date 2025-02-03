package org.august.spigot;

import org.august.core.BookHandler;
import org.august.spigot.format.ColorFormatter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class SpigotBookCreator implements BookHandler {

    public static class Holder {
        public static final SpigotBookCreator INSTANCE = new SpigotBookCreator();
    }

    public static SpigotBookCreator getInstance() {
        return Holder.INSTANCE;
    }

    private final SpigotMessageSender spigotMessageSender = SpigotMessageSender.getInstance();
    private final ColorFormatter colorFormatter = ColorFormatter.getInstance();

    @Override
    public void openBook(Player player, String title, String author, List<String> rules, boolean... settings) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta itemMeta = (BookMeta) book.getItemMeta();

        itemMeta.setTitle(colorFormatter.getColoredText(title));
        itemMeta.setAuthor(colorFormatter.getColoredText(author));

        for (String text : rules) {
            itemMeta.addPage(colorFormatter.getColoredText(text));
        }

        book.setItemMeta(itemMeta);

        if (settings[0]) player.openBook(book);
        if (settings[1]) player.getInventory().addItem(book);
    }

}