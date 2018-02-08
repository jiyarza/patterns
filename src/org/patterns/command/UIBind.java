package org.patterns.command;

public class UIBind {
	
	Command c;
	
	public void setCommand(Command command) { 
		this.c = command;
	}
	
	public void pressButton() { 
		c.execute();
	}
}
