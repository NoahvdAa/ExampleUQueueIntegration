package me.noahvdaa.exampleuqueueintegration;

import me.noahvdaa.uqueue.api.UQueuePlugin;
import net.md_5.bungee.api.plugin.Plugin;

public class ExampleUQueueIntegration extends Plugin {

	private UQueuePlugin uQueue;

	@Override
	public void onEnable() {
		if (getProxy().getPluginManager().getPlugin("uQueue") != null) {
			uQueue = (UQueuePlugin) getProxy().getPluginManager().getPlugin("uQueue");
			// Only register the command if uQueue is loaded!
			getProxy().getPluginManager().registerCommand(this, new ExampleCommand(uQueue));
		} else {
			getLogger().warning("uQueue is not loaded, but this plugin requires it!");
			return;
		}
	}

}
