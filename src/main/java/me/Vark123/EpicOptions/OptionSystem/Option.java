package me.Vark123.EpicOptions.OptionSystem;

import java.lang.reflect.InvocationTargetException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.Vark123.EpicOptions.MenuSystem.IClickAction;
import me.Vark123.EpicOptions.MenuSystem.IOptionItem;

@Getter
@AllArgsConstructor
public class Option <T> {

	private String id;
	private IOptionItem<T> invItem;
	private IClickAction<T> clickAction;
	private T defaultValue;
	
	public Class<?> getValueClass() {
		return defaultValue.getClass();
	}
	
	public T getDefaultValue() {
		return defaultValue;
	}
	
	@SuppressWarnings("unchecked")
	public T getValueNewInstance() {
		try {
			return (T) defaultValue.getClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

}
