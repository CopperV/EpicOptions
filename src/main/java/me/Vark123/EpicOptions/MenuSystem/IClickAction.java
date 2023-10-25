package me.Vark123.EpicOptions.MenuSystem;

import me.Vark123.EpicOptions.PlayerSystem.OPlayer;
import me.Vark123.EpicOptions.PlayerSystem.PlayerOption;

public interface IClickAction <T> {

	public void onClick(OPlayer player, PlayerOption<T> option);
	
}
