package me.Vark123.EpicOptions.OptionSystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Vark123.EpicOptions.MenuSystem.OptionMenuManager;

public class OptionCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!cmd.getName().equalsIgnoreCase("ustawienia"))
			return false;
		if(!(sender instanceof Player))
			return false;
		Player p = (Player) sender;
		OptionMenuManager.get().openMenu(p);
		return true;
	}

}
