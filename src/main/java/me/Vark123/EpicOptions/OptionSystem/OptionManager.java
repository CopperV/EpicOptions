package me.Vark123.EpicOptions.OptionSystem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import lombok.Getter;

@Getter
public final class OptionManager {

	private static final OptionManager inst = new OptionManager();
	
	private final Collection<Option<?>> options;
	
	private OptionManager() {
		options = new HashSet<>();
	}
	
	public static final OptionManager get() {
		return inst;
	}
	
	public void registerOption(Option<?> option) {
		options.add(option);
	}
	
	public Optional<Option<?>> getOptionById(String id) {
		return options.stream()
				.filter(op -> op.getId().equals(id))
				.findAny();
	}
	
}
