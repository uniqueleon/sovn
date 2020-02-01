package org.aztec.sovn.core.mas.utils;

import org.aztec.sovn.core.mas.AgentConstant.MathOperator;

public class GenericNumberUtils {
	
	private static final String VAR_PREFIX = "genericVar";

	public GenericNumberUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T extends Number> T operate(Number number1,Number number2,
			MathOperator operator){
		Double result = 0d;
		switch(operator) {
		case ADD:
			result = number1.doubleValue() + number2.doubleValue();
			break;
		case SUBSTRACT:
			result = number1.doubleValue() - number2.doubleValue();
			break;
		case MULTIPLE:
			result = number1.doubleValue() * number2.doubleValue();
			break;
		case MOD:
			result = number1.doubleValue() % number2.doubleValue();
			break;
		case DIVIDE:
			result = number1.doubleValue() / number2.doubleValue();
			break;
		case POW:
			result = Math.pow(number1.doubleValue(),number2.doubleValue());
			break;
		case BIT_AND:
			result = new Double(number1.intValue() & number2.intValue());
			break;
		case BIT_OR:
			result = new Double(number1.intValue() | number2.intValue());
			break;
		}
		return cast(result,
				number1.getClass());
	}
	
	public static <T extends Number> T cast(Double value,Class objClass) {
		if(objClass.equals(Double.class)) {
			return (T) value;
		}
		else if(objClass.equals(Long.class)) {
			return (T) new Long(value.longValue());
		}
		else if(objClass.equals(Integer.class)) {
			return (T) new Integer(value.intValue());
		}
		else if(objClass.equals(float.class)) {
			return (T) new Float(value.floatValue());
		}
		return null;
	}

}
