package me.Vark123.EpicOptions;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.Vark123.EpicOptions.OptionSystem.Option;
import me.Vark123.EpicOptions.OptionSystem.OptionManager;
import me.Vark123.EpicOptions.OptionSystem.TestInventoryItem;

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
		
		Option<?> option = Option.builder()
				.id("test_id")
				.defaultValue(false)
				.invItem(new TestInventoryItem())
				.build();
		OptionManager.get().registerOption(option);
		
	}

	@Override
	public void onDisable() {
		
	}
}
