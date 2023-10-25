package me.Vark123.EpicOptions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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
	
	@SuppressWarnings("unchecked")
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
		Bukkit.broadcastMessage(Arrays.toString(fYml.getKeys(false).toArray()));
		Collection<PlayerOption<?>> options = new HashSet<>();
		OptionManager.get().getOptions().parallelStream()
			.forEach(option -> {
				Object value = fYml.getObject("options."+option.getId(), option.getValueClass());
				if(value == null)
					value = option.getDefaultValue();
				options.add(PlayerOption.builder()
						.option((Option<Object>) option)
						.value(value)
						.build());
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
//		fYml.set("options", null);
		op.getOptions()
			.forEach(option -> fYml.set("options."+option.getOption().getId(), option.getValue()));
		
		try {
			fYml.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
