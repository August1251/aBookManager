package org.august.bookmanager.dto;

public class SettingsDto {

    private final int cooldown;
    private final boolean bookAutoOpen;
    private final boolean giveTheBookToAPlayer;
    private final boolean cancelTheIssueIfTheInventoryIsFull;
    private final boolean dropTheBookIfTheInventoryIsFull;

    public SettingsDto(int cooldown, boolean bookAutoOpen, boolean giveTheBookToAPlayer, boolean cancelTheIssueIfTheInventoryIsFull, boolean dropTheBookIfTheInventoryIsFull) {
        this.cooldown = cooldown;
        this.bookAutoOpen = bookAutoOpen;
        this.giveTheBookToAPlayer = giveTheBookToAPlayer;
        this.cancelTheIssueIfTheInventoryIsFull = cancelTheIssueIfTheInventoryIsFull;
        this.dropTheBookIfTheInventoryIsFull = dropTheBookIfTheInventoryIsFull;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isBookAutoOpen() {
        return bookAutoOpen;
    }

    public boolean isGiveTheBookToAPlayer() {
        return giveTheBookToAPlayer;
    }

    public boolean isCancelTheIssueIfTheInventoryIsFull() {
        return cancelTheIssueIfTheInventoryIsFull;
    }

    public boolean isDropTheBookIfTheInventoryIsFull() {
        return dropTheBookIfTheInventoryIsFull;
    }

}