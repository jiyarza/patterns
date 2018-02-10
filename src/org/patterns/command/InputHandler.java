package org.patterns.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputHandler {
		
	private Map<String, Command> keyBindings;
	private List<Input> inputQueue;
	
	public InputHandler() {
		keyBindings = new HashMap<String, Command>();
		inputQueue = new ArrayList<Input>();
	}
	
	public void initialize() {
		readFromJson();
	}
	
	private void readFromJson() {
		
	}
	
	public void bind(int key, Command c) {
		bind(String.valueOf(key), c);
	}
	
	public void bind(String key, Command c) {
		keyBindings.put(key, c);
	}
	
	public void handleInputEvent(Input key) {
		if (keyBindings.containsKey(key)) {
			((Command) keyBindings.get(key)).execute();;
		}
	}

}
