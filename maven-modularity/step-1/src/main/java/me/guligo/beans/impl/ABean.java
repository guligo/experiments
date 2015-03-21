package me.guligo.beans.impl;

import me.guligo.beans.Bean;

public class ABean extends Bean {

	@Override
	public void setValue(String value) {
		super.setValue("A" + value);
	}

}
