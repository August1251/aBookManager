package org.august.bookmanager.dto;

import java.util.List;

public class CommandDto {

    private final String description;
    private final String usageMessage;
    private final List<String> aliases;

    public CommandDto(String description, String usageMessage, List<String> aliases) {
        this.description = description;
        this.usageMessage = usageMessage;
        this.aliases = aliases;
    }

    public String getDescription() {
        return description;
    }

    public String getUsageMessage() {
        return usageMessage;
    }

    public List<String> getAliases() {
        return aliases;
    }

}