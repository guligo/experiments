package me.guligo.tests.beans.impl;

import org.junit.Assert;
import org.junit.Test;

import me.guligo.beans.Bean;
import me.guligo.beans.impl.ABean;

public class ABeanTest {

	@Test
	public void testABean() {
		Bean bean = new ABean();
		bean.setValue("Foo");
		Assert.assertEquals("AFoo", bean.getValue());
	}

}
