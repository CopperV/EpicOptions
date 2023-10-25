package me.Vark123.EpicOptions.MenuSystem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.rysefoxx.inventory.plugin.content.IntelligentItem;
import io.github.rysefoxx.inventory.plugin.content.InventoryContents;
import io.github.rysefoxx.inventory.plugin.content.InventoryProvider;
import io.github.rysefoxx.inventory.plugin.pagination.RyseInventory;
import me.Vark123.EpicOptions.Main;
import me.Vark123.EpicOptions.OptionSystem.IOptionItem;
import me.Vark123.EpicOptions.PlayerSystem.PlayerManager;

public final class OptionMenuManager {

	private static final OptionMenuManager inst = new OptionMenuManager();

	private final ItemStack empty;
	
	private OptionMenuManager() {
		empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);{
			ItemMeta im = empty.getItemMeta();
			im.setDisplayName(" ");
			empty.setItemMeta(im);
		}
	}
	
	public static final OptionMenuManager get() {
		return inst;
	}
	
	public void openMenu(Player p) {
		RyseInventory.builder()
			.title("§7§lUSTAWIENIA")
			.rows(6)
			.disableUpdateTask()
			.provider(new InventoryProvider() {
				@Override
				public void init(Player player, InventoryContents contents) {
					for(int i = 0; i < 54; ++i)
						contents.set(i, empty);
					
					PlayerManager.get().getPlayerOptions(player).ifPresent(op -> {
						op.getOptions().forEach(option -> {
							IOptionItem item = option.getOption().getInvItem();
							contents.set(item.getSlot(), IntelligentItem.of(item.getItem(), e -> option.clickAction(op)));
						});
					});
				}
			})
			.build(Main.getInst())
			.open(p);
	}
	
}
