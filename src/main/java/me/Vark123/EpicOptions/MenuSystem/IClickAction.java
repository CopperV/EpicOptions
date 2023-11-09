package me.Vark123.EpicOptions.MenuSystem;

import me.Vark123.EpicOptions.OptionSystem.ISerializable;
import me.Vark123.EpicOptions.PlayerSystem.OPlayer;
import me.Vark123.EpicOptions.PlayerSystem.PlayerOption;

public interface IClickAction <T extends ISerializable> {

	public void onClick(OPlayer player, PlayerOption<T> option);
	
}
