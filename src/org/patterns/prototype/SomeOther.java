package org.patterns.prototype;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class SomeOther extends Some {
	
	private String type = "Object";

	public SomeOther() {
		super();
		setName("Ac"); 
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public Prototype create() {		
		SomeOther obj = new SomeOther();
		try {
			BeanUtils.copyProperties(obj, this);
		} catch (InvocationTargetException ite) {
			
		} catch (IllegalAccessException iae) {
			
		}
		return obj;
	}
}
