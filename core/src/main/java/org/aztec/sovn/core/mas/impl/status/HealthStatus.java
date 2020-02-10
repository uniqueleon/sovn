package org.aztec.sovn.core.mas.impl.status;

import java.util.List;

import org.aztec.sovn.core.mas.StatusValidator;
import org.springframework.stereotype.Component;

@Component
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
		String basicSuccessRate = "basicSuccessRate";
		String leastSuccessRate = "leastSuccessRate";
	}

	public HealthStatus() {
		// TODO Auto-generated constructor stub
		setAttribute(HealthKeys.busyPoint, 0l);
		setAttribute(HealthKeys.networkBusyPoint, 0l);
		setAttribute(HealthKeys.networkLatency, 0l);
		setAttribute(HealthKeys.errorCount, 0l);
		setAttribute(HealthKeys.successCount, 0l);
		setAttribute(HealthKeys.actionCount, 0l);
		setAttribute(HealthKeys.basicSuccessRate, 0.1d);
		setAttribute(HealthKeys.leastSuccessRate, 0.0001d);
	}

	@Override
	protected List<StatusValidator> getValidators() {
		// TODO Auto-generated method stub
		return null;
	}

}
