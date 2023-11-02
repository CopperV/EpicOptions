package me.Vark123.EpicOptions.PlayerSystem;

import java.util.Collection;
import java.util.Optional;

import org.bukkit.entity.Player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class OPlayer {

	private Player player;
	private Collection<PlayerOption<?>> options;
	
	public Optional<PlayerOption<?>> getPlayerOptionByID(String id) {
		return options.parallelStream()
				.filter(option -> option.getOption().getId().equals(id))
				.findAny();
	}
	
}
