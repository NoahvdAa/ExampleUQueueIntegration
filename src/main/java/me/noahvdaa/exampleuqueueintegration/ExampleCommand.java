package me.noahvdaa.exampleuqueueintegration;

import me.noahvdaa.uqueue.api.UQueuePlugin;
import me.noahvdaa.uqueue.api.util.QueueablePlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ExampleCommand extends Command {

	final UQueuePlugin plugin;

	public ExampleCommand(UQueuePlugin plugin) {
		super("exampleuqueueintegration");
		this.plugin = plugin;
	}

	@Override
	public void execute(CommandSender commandSender, String[] args) {
		if (!(commandSender instanceof ProxiedPlayer)) {
			commandSender.sendMessage(new TextComponent(ChatColor.RED + "You must be a player to use this command!"));
			return;
		}

		// Get the player object.
		QueueablePlayer player = plugin.getPlayer((ProxiedPlayer) commandSender);

		if (!player.isQueued()) {
			commandSender.sendMessage(new TextComponent(ChatColor.GOLD + "You are not queued for a server!"));
			return;
		}

		commandSender.sendMessage(new TextComponent(ChatColor.GOLD + "You are queued for " + player.getQueuedServer().getName() + "!"));
		commandSender.sendMessage(new TextComponent(ChatColor.GOLD + "Your position is: " + player.getQueuedServer().getQueuePosition(player) + "/" + player.getQueuedServer().getQueueLength() + "."));
	}

}
