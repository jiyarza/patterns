package org.patterns.prototype;

public class Spawner {
	
	private Prototype p = null;
	
	public Spawner(Prototype p) {
		this.p = p;
	}
	
	public Prototype create() {
		return p.create();
	}

}
