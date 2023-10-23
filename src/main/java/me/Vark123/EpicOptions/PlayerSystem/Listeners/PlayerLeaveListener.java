package me.Vark123.EpicOptions.PlayerSystem.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.Vark123.EpicOptions.FileManager;
import me.Vark123.EpicOptions.PlayerSystem.PlayerManager;

public class PlayerLeaveListener implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		playerCleaner(e.getPlayer());
	}

	@EventHandler
	public void onKick(PlayerKickEvent e) {
		playerCleaner(e.getPlayer());
	}
	
	private void playerCleaner(Player p) {
		PlayerManager.get().getPlayerOptions(p)
			.ifPresent(op -> {
				PlayerManager.get().unregisterPlayerOptions(op);
				FileManager.savePlayer(op);
			});
	}
	
}
