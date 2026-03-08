package net.mvndicraft.kickall;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("kickall")
public class KickAllCommand extends BaseCommand {
    private static final String ADMIN_PERMISSION = "kickall.admin";
    @Default
    @Description("Kick all players")
    @CommandPermission(ADMIN_PERMISSION)
    public static void onKickall(CommandSender commandSender, String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.kick(Component.text(message));
        }
        commandSender.sendMessage(Component.text("All players have been kicked"));
    }

    @Default
    @Description("Kick all players")
    @CommandPermission(ADMIN_PERMISSION)
    public static void onKickall(CommandSender commandSender) { onKickall(commandSender, ""); }
}
