package me.Vark123.EpicOptions.OptionSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.Vark123.EpicOptions.MenuSystem.IClickAction;
import me.Vark123.EpicOptions.MenuSystem.IOptionItem;

@Getter
@AllArgsConstructor
public class Option <T extends ISerializable> {

	protected String id;
	protected IOptionItem<T> invItem;
	protected IClickAction<T> clickAction;
	protected T defaultValue;

}
