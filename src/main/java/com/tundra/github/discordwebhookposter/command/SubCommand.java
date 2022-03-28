package com.tundra.github.discordwebhookposter.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public interface SubCommand {
    Map<String, SubCommand> subcommands = new HashMap<>();

    boolean onCommand(CommandSender sender, Command command, String label, String[] args);
}
