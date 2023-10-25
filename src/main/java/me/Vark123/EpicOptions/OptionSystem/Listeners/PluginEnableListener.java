package me.Vark123.EpicOptions.OptionSystem.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import me.Vark123.EpicOptions.OptionSystem.Events.OptionsRegistryEvent;

public class PluginEnableListener implements Listener {

	@EventHandler
	public void onEnable(PluginEnableEvent e) {
		Event event = new OptionsRegistryEvent();
		Bukkit.getPluginManager().callEvent(event);
	}
	
}
