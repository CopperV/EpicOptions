package me.Vark123.EpicOptions;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.rysefoxx.inventory.plugin.pagination.InventoryManager;
import lombok.Getter;
import me.Vark123.EpicOptions.PlayerSystem.PlayerManager;

@Getter
public class Main extends JavaPlugin {

//	static {
//		ConfigurationSerialization.registerClass(TestClass.class);
//	}
	
	@Getter
	private static Main inst;
	
	private InventoryManager inventoryManager;
	
	@Override
	public void onEnable() {
		inst = this;

		inventoryManager = new InventoryManager(inst);
		inventoryManager.invoke();
		
		FileManager.init();
		ListenerManager.registerListeners();
		CommandManager.setExecutors();
	}

	@Override
	public void onDisable() {
		Bukkit.getOnlinePlayers().stream()
			.map(PlayerManager.get()::getPlayerOptions)
			.filter(op -> op.isPresent())
			.map(op -> op.get())
			.forEach(op -> {
				FileManager.savePlayer(op);
				PlayerManager.get().unregisterPlayerOptions(op);
			});
	}
	
//	@Getter
//	@EqualsAndHashCode
//	class TestClass implements ConfigurationSerializable {
//		
//		private String s;
//		private int i;
//		private double d;
//		
//		public TestClass() {
//			s = "test";
//			i = 10;
//			d = 3.14;
//		}
//
//		@Override
//		public Map<String, Object> serialize() {
//			Map<String, Object> map = new HashMap<>();
//			map.put("s", s);
//			map.put("i", i);
//			map.put("d", d);
//			return map;
//		}
//	}
	
}
