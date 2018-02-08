package org.patterns.command;

public class PayCommand implements Command {

	Actor w;
	
	public PayCommand(Actor w) {
		this.w = w; 
	} 
	
	public void execute() {
		w.walk(); 
	}	
}
