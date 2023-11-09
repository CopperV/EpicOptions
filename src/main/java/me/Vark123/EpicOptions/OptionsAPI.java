package me.Vark123.EpicOptions;

import lombok.Getter;
import me.Vark123.EpicOptions.MenuSystem.OptionMenuManager;
import me.Vark123.EpicOptions.OptionSystem.OptionManager;
import me.Vark123.EpicOptions.PlayerSystem.PlayerManager;

@Getter
public final class OptionsAPI {

	private static final OptionsAPI inst = new OptionsAPI();
	
	private final OptionMenuManager optionMenuManager;
	private final OptionManager optionManager;
	private final PlayerManager playerManager;
	
	private OptionsAPI() {
		optionMenuManager = OptionMenuManager.get();
		optionManager = OptionManager.get();
		playerManager = PlayerManager.get();
	}
	
	public static final OptionsAPI get() {
		return inst;
	}
	
}
