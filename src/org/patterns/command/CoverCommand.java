package org.patterns.command;

public class CoverCommand implements Command {

	Actor w;
	
	public CoverCommand(Actor w) {
		this.w = w;
		
	} 
	
	public void execute() {
		w.stop(); 
	}	
}
