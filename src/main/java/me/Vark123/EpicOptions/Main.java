package me.Vark123.EpicOptions;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

@Getter
public class Main extends JavaPlugin {

	@Getter
	private static Main inst;
	
	@Override
	public void onEnable() {
		inst = this;
		
		FileManager.init();
		ListenerManager.registerListeners();
		CommandManager.setExecutors();
		
	}

	@Override
	public void onDisable() {
		
	}
}
