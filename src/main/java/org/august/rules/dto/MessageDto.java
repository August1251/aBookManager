package org.august.rules.dto;

import java.util.List;

public class MessageDto {

    private final boolean enabled;
    private final List<String> messages;

    public MessageDto(boolean enabled, List<String> messages) {
        this.enabled = enabled;
        this.messages = messages;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<String> getMessage() {
        return messages;
    }

}