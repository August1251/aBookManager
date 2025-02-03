package org.august.bookmanager.dto;

import java.util.List;

public class MessageDto {

    private final String index;
    private final boolean enabled;
    private final List<String> messages;

    public MessageDto(String index, boolean enabled, List<String> messages) {
        this.index = index;
        this.enabled = enabled;
        this.messages = messages;
    }

    public String getIndex() {
        return index;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<String> getMessage() {
        return messages;
    }

}