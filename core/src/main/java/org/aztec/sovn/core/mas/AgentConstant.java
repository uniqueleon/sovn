package org.aztec.sovn.core.mas;

public interface AgentConstant {

	
	public static enum BaseKownledge{
		STATUS_NUMBER_OPT("numberOpt"),
		STATUS_MESSAGE_UPDATE("msgUpdate"),
		STATUS_FLAG_UPDATE("flagUpdate"),
		TALK("talk"),
		SLEEP("sleep"),
		WAKEUP("wakeup"),
		DEAD("dead");
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private BaseKownledge(String name) {
			this.name = name;
		}
		
		
	}
}
