package com.tundra.github.discordwebhookposter;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public static String getWebhookURL() {
        FileConfiguration config = DiscordWebhookPoster.getConfigure();
        if (!config.contains("WebhookURL")) throw new NullPointerException("The config file is blank");
        if (config.getString("WebhookURL") != null) {
            return config.getString("WebhookURL");
        } else throw new NullPointerException("The config file is blank");
    }
}
