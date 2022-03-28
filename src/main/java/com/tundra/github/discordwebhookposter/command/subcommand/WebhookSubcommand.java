package com.tundra.github.discordwebhookposter.command.subcommand;

import com.tundra.finelib.FineLib;
import com.tundra.finelib.http.discord.WebHook;
import com.tundra.finelib.http.discord.builder.WebHookPropertyBuilder;
import com.tundra.github.discordwebhookposter.Config;
import com.tundra.github.discordwebhookposter.command.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class WebhookSubcommand implements SubCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        WebHook webHook = new WebHook(Config.getWebhookURL());
        if (sender instanceof Player player){
            args[0] = args[0].toLowerCase();
            webHook.setProperty(new WebHookPropertyBuilder()
                    .setUserName(player.getDisplayName())
                    .setAvatarURL("https://crafatar.com/avatars/"+ ((Player)sender).getUniqueId() +"?size=128&default=MHF_Steve&overlay")
                    .setContent(Arrays.toString(args)
                            .replaceFirst("webhook","")
                            .replace(","," ")
                            .replace("[","")
                            .replace("]","")));
            webHook.postWebHook();
        }
        else {
            args[0] = args[0].toLowerCase();
            webHook.setProperty(new WebHookPropertyBuilder()
                    .setUserName("Server")
                    .setAvatarURL("")
                    .setContent(Arrays.toString(args)
                            .replaceFirst("webhook","")
                            .replace(","," ")
                            .replace("[","")
                            .replace("]","")));
        }
        return false;
    }
}
