package org.aztec.sovn.core.mas.impl.status;

import java.util.List;

import org.aztec.sovn.core.mas.StatusValidator;

public class HealthStatus extends BasicStatus {
	
	
	public static interface HealthKeys{
		/**
		 *  To show  how busy the agent was.
		 */
		String busyPoint = "busyPoint";
		/**
		 *  To show how busy the network connection was . 
		 */
		String networkBusyPoint = "networkBusyPoint";
		
		String networkLatency = "networkLatency";
		String errorCount = "errorCount";
		String successCount = "successCount";
		String actionCount = "actionCount";
	}

	public HealthStatus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected List<StatusValidator> getValidators() {
		// TODO Auto-generated method stub
		return null;
	}

}
