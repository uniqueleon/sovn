package org.aztec.sovn.core.mas;

public interface AgentConstant {
	
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
}
