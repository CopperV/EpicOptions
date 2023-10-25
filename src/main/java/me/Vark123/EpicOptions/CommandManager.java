package me.Vark123.EpicOptions;

import org.bukkit.Bukkit;

import me.Vark123.EpicOptions.OptionSystem.OptionCommand;

public final class CommandManager {

	private CommandManager() { }
	
	public static final void setExecutors() {
		Bukkit.getPluginCommand("ustawienia").setExecutor(new OptionCommand());
	}
	
}
