package com.turgayzengin.simplecrm.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class BaseEntity implements Serializable {
	private boolean isActive = true;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
