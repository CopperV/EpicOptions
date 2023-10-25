package me.Vark123.EpicOptions;

import org.bukkit.Bukkit;

import me.Vark123.EpicOptions.OptionSystem.Listeners.LoadPlayersAfterRegistryListener;
import me.Vark123.EpicOptions.OptionSystem.Listeners.PluginEnableListener;
import me.Vark123.EpicOptions.PlayerSystem.Listeners.PlayerJoinListener;
import me.Vark123.EpicOptions.PlayerSystem.Listeners.PlayerLeaveListener;

public final class ListenerManager {

	private ListenerManager() { }
	
	public static final void registerListeners() {
		Main inst = Main.getInst();
		
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), inst);
		Bukkit.getPluginManager().registerEvents(new PlayerLeaveListener(), inst);
		Bukkit.getPluginManager().registerEvents(new PluginEnableListener(), inst);
		Bukkit.getPluginManager().registerEvents(new LoadPlayersAfterRegistryListener(), inst);
	}
	
}
