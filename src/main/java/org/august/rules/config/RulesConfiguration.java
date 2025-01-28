package org.august.rules.config;

import org.august.rules.aRules;
import org.august.rules.dto.BookDto;
import org.august.rules.format.ColorFormatter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class RulesConfiguration {

    private final ColorFormatter colorFormatter = ColorFormatter.getInstance();

    public static class Holder {
        public static final RulesConfiguration INSTANCE = new RulesConfiguration();
    }

    public static RulesConfiguration getInstance() {
        return Holder.INSTANCE;
    }

    private static aRules rules;

    public FileConfiguration getConfig() {
        return rules.getConfig();
    }

    public BookDto getBook() {
        String title = colorFormatter.getFormattedColor(getConfig().getString("title"));
        String author = colorFormatter.getFormattedColor(getConfig().getString("author"));

        List<String> rules = new ArrayList<>();

        for (String page : getRulesSection().getKeys(false)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String i : getRule(page)) {
                stringBuilder.append(colorFormatter.getFormattedColor(i));
                stringBuilder.append("\n");
            }
            rules.add(stringBuilder.toString());
        }

        return new BookDto(title, author, rules);

    }

    public ConfigurationSection getRulesSection() {
        return getConfig().getConfigurationSection("rules");
    }

    public List<String> getRule(String page) {
        return getRulesSection().getStringList(page);
    }

    public static void setRules(aRules rules) {
        RulesConfiguration.rules = rules;
    }

}