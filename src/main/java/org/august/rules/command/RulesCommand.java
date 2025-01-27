package org.august.rules.command;

import org.august.rules.aRules;
import org.august.rules.config.MessagesConfiguration;
import org.august.rules.config.RulesConfiguration;
import org.august.rules.dto.BookDto;
import org.august.rules.manager.MessageManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.jetbrains.annotations.NotNull;

public class RulesCommand implements CommandExecutor {

    private final MessagesConfiguration messagesConfiguration = MessagesConfiguration.getInstance();
    private final RulesConfiguration rulesConfiguration = RulesConfiguration.getInstance();
    private final MessageManager messageManager = MessageManager.getInstance();
    private final aRules rules;

    public RulesCommand(aRules rules) {
        this.rules = rules;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (!player.hasPermission("arules.rules")) {
                messageManager.sendMessage(messagesConfiguration.getMessage("rules-command-you-don't-have-permission"), player);
                return false;
            }

            BookDto bookDto = rulesConfiguration.getBook();
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

            BookMeta itemMeta = (BookMeta) book.getItemMeta();
            itemMeta.setTitle(bookDto.getTitle());
            itemMeta.setAuthor(bookDto.getAuthor());
            itemMeta.setPages(bookDto.getRules());

            book.setItemMeta(itemMeta);

            player.openBook(book);
            messageManager.sendMessage(messagesConfiguration.getMessage("rules-command-successfully"), player);

            return true;
        } else {
            messageManager.sendMessage(messagesConfiguration.getMessage("command-sender-is-not-player"));
        }
        return false;
    }

}