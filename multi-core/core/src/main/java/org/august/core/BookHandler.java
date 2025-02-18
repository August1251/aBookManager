package org.august.core;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public abstract class BookHandler {

    public abstract void openBook(Player player, String title, String author, List<String> rules, boolean... settings);

    protected boolean isInventoryFull(Player player, ItemStack book) {
        Inventory inventory = player.getInventory();
        boolean inventoryIsFull = false;
        for (int i = 0; i < 36; i++) {
            if (inventory.getItem(i) == null) {
                inventoryIsFull = true;
            } else {
                inventoryIsFull = inventory.getItem(i).equals(book);
            }
        }
        return inventoryIsFull;
    }

}