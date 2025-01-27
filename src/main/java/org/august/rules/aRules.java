package org.august.rules;

import org.august.rules.command.RulesCommand;
import org.august.rules.config.MessagesConfiguration;
import org.august.rules.config.RulesConfiguration;
import org.august.rules.manager.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class aRules extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        configure();
        registerCommands();
    }

    private void configure() {
        MessageManager.setRules(this);
        RulesConfiguration.setRules(this);
        MessagesConfiguration.setRules(this);
    }

    private void registerCommands() {
        getCommand("rules").setExecutor(new RulesCommand(this));
    }

}