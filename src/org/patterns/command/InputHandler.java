package org.patterns.command;

import java.util.HashMap;
import java.util.Map;

public class InputHandler {
		
	private Map<String, Command> keyBindings;
	
	public InputHandler() {
		keyBindings = new HashMap<String, Command>();
	}
	
	public void bind(int key, Command c) {
		bind(String.valueOf(key), c);
	}
	
	public void bind(String key, Command c) {
		keyBindings.put(key, c);
	}
	
	public void handleInputEvent(Event key) {
		Command c = (Command) keyBindings.get(key);
		if (c != null) {
			c.execute();
		}
	}

}
