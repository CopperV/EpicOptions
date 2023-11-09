package me.Vark123.EpicOptions.OptionSystem;

public interface IOptionAccessor <T> {
	
	public T getValue();
	public void setValue(T value);

}
