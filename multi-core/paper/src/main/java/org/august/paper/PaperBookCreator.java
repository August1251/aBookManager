package org.august.paper;

import org.august.core.BookHandler;
import org.august.paper.format.ComponentFormatter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class PaperBookCreator implements BookHandler {

    public static class Holder {
        public static final PaperBookCreator INSTANCE = new PaperBookCreator();
    }

    public static PaperBookCreator getInstance() {
        return Holder.INSTANCE;
    }

    private final PaperMessageSender paperMessageSender = PaperMessageSender.getInstance();
    private final ComponentFormatter componentFormatter = ComponentFormatter.getInstance();

    @Override
    public void openBook(Player player, String title, String author, List<String> rules, boolean... settings) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta itemMeta = (BookMeta) book.getItemMeta();

        itemMeta.title(componentFormatter.getComponentizedText(title));
        itemMeta.author(componentFormatter.getComponentizedText(author));

        for (String text : rules) {
            itemMeta.addPages(componentFormatter.getComponentizedText(text));
        }

        book.setItemMeta(itemMeta);

        if (settings[0]) player.openBook(book);
        if (settings[1]) player.getInventory().addItem(book);

    }

}