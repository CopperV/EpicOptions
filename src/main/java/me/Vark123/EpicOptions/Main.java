package me.Vark123.EpicOptions;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.rysefoxx.inventory.plugin.pagination.InventoryManager;
import lombok.Getter;
import me.Vark123.EpicOptions.OptionSystem.Option;
import me.Vark123.EpicOptions.OptionSystem.OptionManager;
import me.Vark123.EpicOptions.OptionSystem.TestInventoryItem;

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
		
//		Option<?> option = new Option<Boolean>(
//				getName(), 
//				new TestInventoryItem(), 
//				(op, pOption) -> {
//					boolean value = pOption.getValue();
//					pOption.setValue(Boolean.valueOf(!value));
//				}, 
//				false);
		Option<?> option = Option.builder()
				.id("test_id")
				.invItem(new TestInventoryItem())
				.defaultValue(false)
				.clickAction((op, pOption) -> {
					boolean value = (boolean) pOption.getValue();
					op.getPlayer().sendMessage("Zmieniam na "+!value);
					pOption.setValue(Boolean.valueOf(!value));
				})
				.build();
		OptionManager.get().registerOption(option);
		
	}

	@Override
	public void onDisable() {
		
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
