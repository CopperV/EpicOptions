package me.Vark123.EpicOptions.PlayerSystem.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Vark123.EpicOptions.FileManager;
import me.Vark123.EpicOptions.PlayerSystem.OPlayer;
import me.Vark123.EpicOptions.PlayerSystem.PlayerManager;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		OPlayer op = FileManager.loadPlayerOptions(p);
		PlayerManager.get().registerPlayerOptions(op);
	}
	
}
