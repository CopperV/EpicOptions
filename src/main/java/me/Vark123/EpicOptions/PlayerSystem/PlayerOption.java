package me.Vark123.EpicOptions.PlayerSystem;

import org.bukkit.inventory.ItemStack;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import me.Vark123.EpicOptions.OptionSystem.IOptionAccessor;
import me.Vark123.EpicOptions.OptionSystem.Option;

@Getter
@Builder
public class PlayerOption<T> implements IOptionAccessor<T> {
	
	private Option<T> option;
	@Getter(value = AccessLevel.NONE)
	private T value;
	
//	public PlayerOption(Option<T> option, T value) {
//		this.option = option;
//		this.value = value;
//	}
	
	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}
	
	public void clickAction(OPlayer op) {
		option.getClickAction().onClick(op, this);
	}
	
	public ItemStack getItem(OPlayer op) {
		return option.getInvItem().getItem(op, this);
	}

}
