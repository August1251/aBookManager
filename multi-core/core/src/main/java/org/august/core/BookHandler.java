package org.august.core;

import org.bukkit.entity.Player;

import java.util.List;

public interface BookHandler {

    void openBook(Player player, String title, String author, List<String> rules);

}