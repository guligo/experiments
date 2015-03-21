package me.guligo.beans.impl;

import me.guligo.beans.Bean;

public class CBean extends Bean {

	@Override
	public void setValue(String value) {
		super.setValue("C" + value);
	}

}
