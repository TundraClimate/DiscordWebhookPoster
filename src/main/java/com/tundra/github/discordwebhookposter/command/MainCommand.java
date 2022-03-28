package com.tundra.github.discordwebhookposter.command;

import com.tundra.github.discordwebhookposter.command.subcommand.WebhookSubcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MainCommand implements CommandExecutor {
    public MainCommand(JavaPlugin plugin){plugin.getCommand("d").setExecutor(this);}

    public static void init() {
        SubCommand.subcommands.put("webhook", new WebhookSubcommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("d")) return true;
        if (args.length <= 1) return false;
        if (SubCommand.subcommands.containsKey(args[0])) {
            return SubCommand.subcommands.get(args[0]).onCommand(sender, command, label, args);
        }
        return false;
    }
}
