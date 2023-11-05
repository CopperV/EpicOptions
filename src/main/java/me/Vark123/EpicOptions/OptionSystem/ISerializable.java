package me.Vark123.EpicOptions.OptionSystem;

import org.bukkit.configuration.ConfigurationSection;

public interface ISerializable {

	public void serialize(ConfigurationSection section);
	public void deserialize(ConfigurationSection section);
	public ISerializable copy();
	
}
