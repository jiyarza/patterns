package org.patterns.prototype;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class Some implements Prototype {
	
	private int maxh;
	private int maxm;
	private String name;
	private List<Item> items;
	
	public Some() {
		initialize();
	}
	
	/*
	 * initialize data
	 * 
	 */
	private void initialize() {
		name = "Default";
		maxh = 12;
		maxm = 10;
		items = new ArrayList<Item>();
		items.add(new Item("Pitchfork",32));
		items.add(new Item("Boots",32));
		load();
	}
	
	/*
	 * Load from storage
	 */
	private void load() {
		
	}
	
	public Prototype create() {
		Some obj = new Some();
		try {
			BeanUtils.copyProperties(obj, this);
		} catch (InvocationTargetException ite) {
			
		} catch (IllegalAccessException iae) {
			
		}
		return obj;
	}

	public String toString() {
		return "Name=" + name + ", MaxH=" + maxh + ", MaxM=" + maxm;
	}
	
	public int getMaxh() {
		return maxh;
	}

	public void setMaxh(int maxh) {
		this.maxh = maxh;
	}

	public int getMaxm() {
		return maxm;
	}

	public void setMaxm(int maxm) {
		this.maxm = maxm;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
