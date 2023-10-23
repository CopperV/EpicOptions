package me.Vark123.EpicOptions.PlayerSystem;

import lombok.AccessLevel;
import lombok.Getter;
import me.Vark123.EpicOptions.OptionSystem.IOptionAccessor;
import me.Vark123.EpicOptions.OptionSystem.Option;

@Getter
public class PlayerOption <T> implements IOptionAccessor<T> {
	
	private Option<? extends T> option;
	@Getter(value = AccessLevel.NONE)
	private T value;
	
	public PlayerOption(Option<? extends T> option, T value) {
		this.option = option;
		this.value = value;
	}
	
	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

}
