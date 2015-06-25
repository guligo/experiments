package me.guligo.ejb.calculator;

public class CalculatorBeanBase implements CalculatorCommonBusiness {

	@Override
	public int add(int... args) {
		int result = 0;
		if (args != null) {
			for (int arg : args) {
				result += arg;
			}
		}
		return result;
	}

}
