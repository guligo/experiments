package me.guligo.beans.impl;

import me.guligo.beans.Bean;

public class BBean extends Bean {

	@Override
	public void setValue(String value) {
		super.setValue("B" + value);
	}

}
