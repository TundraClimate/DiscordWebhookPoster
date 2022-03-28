package com.tundra.github.discordwebhookposter;

import com.tundra.finelib.FineLib;
import com.tundra.github.discordwebhookposter.command.MainCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiscordWebhookPoster extends JavaPlugin {
    private static FileConfiguration config;

    @Override
    public void onEnable() {
        FineLib.setPlugin(this);
        saveDefaultConfig();
        config = getConfig();
        new MainCommand(this);
        MainCommand.init();
    }

    public static FileConfiguration getConfigure(){
        return config;
    }
}
