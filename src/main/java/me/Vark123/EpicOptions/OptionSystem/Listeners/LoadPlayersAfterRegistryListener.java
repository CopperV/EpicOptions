package me.Vark123.EpicOptions.OptionSystem.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import me.Vark123.EpicOptions.FileManager;
import me.Vark123.EpicOptions.OptionSystem.Events.OptionsRegistryEvent;
import me.Vark123.EpicOptions.PlayerSystem.OPlayer;
import me.Vark123.EpicOptions.PlayerSystem.PlayerManager;

public class LoadPlayersAfterRegistryListener implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onRegister(OptionsRegistryEvent e) {
		Bukkit.getOnlinePlayers().forEach(p -> {
			OPlayer op = FileManager.loadPlayerOptions(p);
			PlayerManager.get().registerPlayerOptions(op);
		});
	}
	
}
