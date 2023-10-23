package me.Vark123.EpicOptions.PlayerSystem;

import java.util.Collection;

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
	
}
