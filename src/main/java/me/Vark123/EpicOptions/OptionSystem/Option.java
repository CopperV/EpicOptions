package me.Vark123.EpicOptions.OptionSystem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Option <T> {

	private String id;
	private IInventoryItem invItem;
	private T defaultValue;
	
	public Class<?> getValueClass() {
		return defaultValue.getClass();
	}
	
	public T getDefaultValue() {
		return defaultValue;
	}

}
