package me.Vark123.EpicOptions.MenuSystem;

import org.bukkit.inventory.ItemStack;

import me.Vark123.EpicOptions.PlayerSystem.OPlayer;
import me.Vark123.EpicOptions.PlayerSystem.PlayerOption;

public interface IOptionItem <T> {

	public ItemStack getItem(OPlayer player, PlayerOption<T> option);
	public int getSlot();
	
}
