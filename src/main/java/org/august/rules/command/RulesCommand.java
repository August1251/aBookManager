package org.august.rules.command;

import org.august.rules.config.MessagesConfiguration;
import org.august.rules.config.RulesConfiguration;
import org.august.rules.manager.BookManager;
import org.august.rules.manager.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RulesCommand implements CommandExecutor {

    private final MessagesConfiguration messagesConfiguration = MessagesConfiguration.getInstance();
    private final RulesConfiguration rulesConfiguration = RulesConfiguration.getInstance();
    private final MessageManager messageManager = MessageManager.getInstance();
    private final BookManager bookManager = BookManager.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("arules.rules")) {
                messageManager.sendMessage(messagesConfiguration.getMessage("rules-command-you-don't-have-permission"), player);
                return false;
            }
            bookManager.openBook(player, rulesConfiguration.getBook());
            messageManager.sendMessage(messagesConfiguration.getMessage("rules-command-successfully"), player);
            return true;
        } else {
            messageManager.sendMessage(messagesConfiguration.getMessage("command-sender-is-not-player"));
        }
        return false;
    }

}