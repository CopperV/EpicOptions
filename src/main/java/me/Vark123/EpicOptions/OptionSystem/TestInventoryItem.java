package me.Vark123.EpicOptions.OptionSystem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TestInventoryItem implements IOptionItem {

	@Override
	public ItemStack getItem() {
		return new ItemStack(Material.ACACIA_BUTTON);
	}

	@Override
	public int getSlot() {
		return 0;
	}
}
