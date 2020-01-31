package org.aztec.sovn.core.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.api.client.util.Maps;

/**
 * 算术表达式计算
 * @author uniqueleon
 *
 */
public class Eval {
	
	public static enum MathOperator{
		ADD('+'),
		SUBSTRACT('-'),
		MULTIPLE('*'),
		DIVIDE('/'),
		POW('^'),
		MOD('%'),
		BIT_AND('&'),
		BIT_OR('|');
		
		char opt;

		private MathOperator(char opt) {
			this.opt = opt;
		}
		
		public static MathOperator getOperator(char optChar) {
			for(MathOperator opt : MathOperator.values()) {
				if(opt.opt == optChar) {
					return opt;
				}
			}
			return null;
		}
	}
	
	private static Pattern OperationPattern = Pattern.compile("\'[\\+|\\-|\\*|\\/|\\%|\\^|\\%|\\&|\\|]\'\\(\\w+,\\w+\\)");

	//'+'(a,'/'(b,c))
	/**
	 * 计算中序法生成的表达式 
	 * @param expr 中序法表达式
	 * @param params 表达式中参数的值
	 * @return
	 */
	public static double eval(String expr,Map<String,Double> params) {
		
		
		String tmpStr = expr.trim();
		Map<String,Double> tmpMap = Maps.newHashMap();
		tmpMap.putAll(params);
		int cursor = 0;
		Matcher matcher = OperationPattern.matcher(tmpStr);
		Expression expression = null;
		while(matcher.find()) {
			String group1 = matcher.group();
			expression = new Expression(group1, cursor);
			expression.calculate(tmpMap);
			tmpMap.put(expression.getTmpName(), expression.getResult());
			tmpStr = tmpStr.replace(group1, expression.getTmpName());
			matcher = OperationPattern.matcher(tmpStr);
		}
		return expression != null ? expression.getResult() : 0;
	}
	
	private static class Expression{
		String opt1;
		String opt2;
		String tmpName;
		MathOperator operator;
		double result = 0;
		public String getOpt1() {
			return opt1;
		}
		public void setOpt1(String opt1) {
			this.opt1 = opt1;
		}
		public String getOpt2() {
			return opt2;
		}
		public void setOpt2(String opt2) {
			this.opt2 = opt2;
		}
		public MathOperator getOperator() {
			return operator;
		}
		public void setOperator(MathOperator operator) {
			this.operator = operator;
		}
		public Expression(String expr,int index) {
			super();
			operator = getOperator(expr);
			expr = expr.substring(4,expr.length() - 1);
			String[] vars = expr.split(",");
			opt1 = vars[0];
			opt2 = vars[1];
			this.tmpName = "optTmp_" + index;
		}
		
		public void calculate(Map<String,Double> tmpMap) {
			Double val1 = tmpMap.get(opt1);
			Double val2 = tmpMap.get(opt2);
			switch(operator) {
			case ADD:
				result = val1 + val2;
				break;
			case SUBSTRACT:
				result = val1 - val2;
				break;
			case MULTIPLE:
				result = val1 * val2;
				break;
			case DIVIDE:
				result = val1 / val2;
				break;
			case MOD:
				result = new Double(val1.longValue() % val2.longValue());
				break;
			case POW:
				result = Math.pow(val1, val2);
				break;
			case BIT_AND:
				result = val1.intValue() & val2.intValue();
				break;
			case BIT_OR:
				result = val1.intValue() | val2.intValue();
				break;
				default :
					result = 0;
			}
		}
		
		private MathOperator getOperator(String expr) {
			if(expr.startsWith("'")) {
				char optChar = expr.charAt(1);
				return MathOperator.getOperator(optChar);
			}
			return null;
		}
		public String getTmpName() {
			return tmpName;
		}
		public double getResult() {
			return result;
		}
			
	}
	
	public static void main(String[] args) {
		Map<String,Double> params = Maps.newHashMap();
		params.put("aPc", 1d);
		params.put("bPc_1",2d);
		params.put("cPc",3d);
		String expr = "'/'('+'(aPc,bPc_1),cPc)";
		System.out.println(Eval.eval(expr, params));
//		String testStr = "'+'(abc,abc_1)";
//		System.out.println(OperationPattern.matcher(testStr).find());
		
	}
	
}
