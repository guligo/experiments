package me.guligo.tests.beans.impl;

import org.junit.Assert;
import org.junit.Test;

import me.guligo.beans.Bean;
import me.guligo.beans.impl.CBean;

public class CBeanTest {

	@Test
	public void testCBean() {
		Bean bean = new CBean();
		bean.setValue("Foo");
		Assert.assertEquals("CFoo", bean.getValue());
	}

}
