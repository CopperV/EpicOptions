package me.Vark123.EpicOptions.OptionSystem.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerLoadEvent;

import me.Vark123.EpicOptions.Main;
import me.Vark123.EpicOptions.OptionSystem.OptionManager;
import me.Vark123.EpicOptions.OptionSystem.Events.OptionsRegistryEvent;

public class PluginEnableListener implements Listener {

	@EventHandler
	public void onEnable(PluginEnableEvent e) {
		if(!e.getPlugin().equals(Main.getInst()))
			return;
		Event event = new OptionsRegistryEvent();
		Bukkit.getPluginManager().callEvent(event);
	}
	
	@EventHandler
	public void onLoad(ServerLoadEvent e) {
		OptionManager.get().getOptions().clear();
		Event event = new OptionsRegistryEvent();
		Bukkit.getPluginManager().callEvent(event);
	}
	
}
