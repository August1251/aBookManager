package org.august.bookmanager.command;

import org.august.bookmanager.config.MessagesConfiguration;
import org.august.bookmanager.config.BooksConfiguration;
import org.august.bookmanager.dto.BookDto;
import org.august.bookmanager.dto.SettingsDto;
import org.august.bookmanager.manager.BookManager;
import org.august.bookmanager.manager.MessageManager;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseCommand extends BukkitCommand {

    private final MessagesConfiguration messagesConfiguration = MessagesConfiguration.getInstance();
    private final BooksConfiguration booksConfiguration = BooksConfiguration.getInstance();
    private final MessageManager messageManager = MessageManager.getInstance();
    private final BookManager bookManager = BookManager.getInstance();

    private final String name;

    public BaseCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
        this.name = name;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (sender instanceof Player) {

            BookDto bookDto = booksConfiguration.getBook(name);
            SettingsDto settingsDto = bookDto.getSettingsDto();
            Player player = (Player) sender;

            if (!player.hasPermission(new StringBuilder("abookmanager.").append(bookDto.getName()).toString())) {
                messageManager.sendMessage(messagesConfiguration.getMessage(name, "bookmanager-command-you-don't-have-permission"), player);
                return false;
            }

            if (settingsDto.isCancelTheIssueIfTheInventoryIsFull() && !hasAvailableSlot(player)) {
                messageManager.sendMessage(messagesConfiguration.getMessage(name, "bookmanager-command-if-inventory-is-full"), player);
                return false;
            }

            bookManager.openBook(player, bookDto);
            messageManager.sendMessage(messagesConfiguration.getMessage(name, "bookmanager-command-successfully"), player);

            return true;
        } else {
            messageManager.sendMessage(messagesConfiguration.getMessage(name, "bookmanager-sender-is-not-player"));
        }
        return false;
    }

    private boolean hasAvailableSlot(Player player){
        Inventory inv = player.getInventory();
        for (int i = 0; i <= 35; i ++) {
            if (inv.getItem(i) == null) return true;
        }
        return false;
    }

}