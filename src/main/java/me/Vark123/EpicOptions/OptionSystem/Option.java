package me.Vark123.EpicOptions.OptionSystem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Option <T> {

	private String id;
	private IOptionItem invItem;
	private IClickAction<T> clickAction;
	private T defaultValue;
	
	public Class<?> getValueClass() {
		return defaultValue.getClass();
	}
	
	public T getDefaultValue() {
		return defaultValue;
	}

}
