package me.Vark123.EpicOptions.PlayerSystem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.bukkit.entity.Player;

import lombok.Getter;

@Getter
public final class PlayerManager {

	private static final PlayerManager inst = new PlayerManager();
	
	private final Collection<OPlayer> players;
	
	private PlayerManager() {
		players = new HashSet<>();
	}
	
	public static final PlayerManager get() {
		return inst;
	}
	
	public void registerPlayerOptions(OPlayer player) {
		players.add(player);
	}
	
	public void unregisterPlayerOptions(OPlayer player) {
		players.remove(player);
	}
	
	public Optional<OPlayer> getPlayerOptions(Player player) {
		return players.stream()
				.filter(p -> p.getPlayer().equals(player))
				.findAny();
	}
	
}
