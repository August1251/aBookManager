package org.august.bookmanager.dto;

public class SettingsDto {

    private final boolean bookAutoOpen;
    private final boolean giveTheBookToAPlayer;
    private final boolean cancelTheIssueIfTheInventoryIsFull;

    public SettingsDto(boolean bookAutoOpen, boolean giveTheBookToAPlayer, boolean cancelTheIssueIfTheInventoryIsFull) {
        this.bookAutoOpen = bookAutoOpen;
        this.giveTheBookToAPlayer = giveTheBookToAPlayer;
        this.cancelTheIssueIfTheInventoryIsFull = cancelTheIssueIfTheInventoryIsFull;
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

}