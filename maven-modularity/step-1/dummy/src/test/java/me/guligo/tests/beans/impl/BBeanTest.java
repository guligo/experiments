package me.guligo.tests.beans.impl;

import org.junit.Assert;
import org.junit.Test;

import me.guligo.beans.Bean;
import me.guligo.beans.impl.BBean;

public class BBeanTest {

	@Test
	public void testBBean() {
		Bean bean = new BBean();
		bean.setValue("Foo");
		Assert.assertEquals("BFoo", bean.getValue());
	}

}
