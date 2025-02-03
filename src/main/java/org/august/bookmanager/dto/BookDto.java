package org.august.bookmanager.dto;

import java.util.List;

public class BookDto {

    private final String name;
    private final String title;
    private final String author;
    private final List<String> pages;

    private final CommandDto commandDto;
    private final SettingsDto settingsDto;
    private final List<MessageDto> messageDto;

    public BookDto(String name, String title, String author, List<String> pages, CommandDto commandDto, SettingsDto settingsDto, List<MessageDto> messageDto) {
        this.name = name;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.commandDto = commandDto;
        this.settingsDto = settingsDto;
        this.messageDto = messageDto;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getPages() {
        return pages;
    }

    public CommandDto getCommandDto() {
        return commandDto;
    }

    public SettingsDto getSettingsDto() {
        return settingsDto;
    }

    public List<MessageDto> getMessageDto() {
        return messageDto;
    }

}