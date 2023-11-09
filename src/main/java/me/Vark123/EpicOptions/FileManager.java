package me.Vark123.EpicOptions;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.Vark123.EpicOptions.OptionSystem.ISerializable;
import me.Vark123.EpicOptions.OptionSystem.Option;
import me.Vark123.EpicOptions.OptionSystem.OptionManager;
import me.Vark123.EpicOptions.PlayerSystem.OPlayer;
import me.Vark123.EpicOptions.PlayerSystem.PlayerOption;

public final class FileManager {

	private static final File playerDir = new File(Main.getInst().getDataFolder(), "players");
	
	private FileManager() { }
	
	public static final void init() {
		if(!Main.getInst().getDataFolder().exists())
			Main.getInst().getDataFolder().mkdir();
		if(!playerDir.exists())
			playerDir.mkdir();
	}
	
	public static OPlayer loadPlayerOptions(Player p) {
		String fileName = p.getUniqueId().toString()+".yml";
		File f = new File(playerDir, fileName);
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		YamlConfiguration fYml = YamlConfiguration.loadConfiguration(f);
		Collection<PlayerOption<?>> options = new HashSet<>();
		OptionManager.get().getOptions().parallelStream()
			.forEach(option -> {
				ISerializable value = option.getDefaultValue().copy();
				ConfigurationSection section = fYml.getConfigurationSection(option.getId());
				if(section != null) {
					value.deserialize(section);
				}
				@SuppressWarnings("unchecked")
				PlayerOption<?> pOption = PlayerOption.builder()
						.option((Option<ISerializable>) option)
						.value(value)
						.build();
				options.add(pOption);
			});
		
		return OPlayer.builder()
				.player(p)
				.options(options)
				.build();
	}
	
	public static void savePlayer(OPlayer op) {
		Player p = op.getPlayer();
		String fileName = p.getUniqueId().toString()+".yml";
		File f = new File(playerDir, fileName);
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		YamlConfiguration fYml = YamlConfiguration.loadConfiguration(f);
		fYml.set("last-nick", p.getName());
		op.getOptions()
			.forEach(option -> {
				Option<?> _option = option.getOption();
				if(!fYml.isConfigurationSection(_option.getId()))
					fYml.createSection(_option.getId());
				ConfigurationSection section = fYml.getConfigurationSection(_option.getId());
				option.getValue().serialize(section);
			});

		try {
			fYml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
