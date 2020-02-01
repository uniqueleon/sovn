package org.aztec.sovn.core.mas.impl.status;

import java.util.List;

import org.aztec.sovn.core.mas.StatusValidator;

public class HealthStatus extends BasicStatus {
	
	
	public static interface HealthKeys{
		/**
		 *  if this value equals 0 or below 0, the agent will "die".
		 */
		String HealthPoint = "HP";
		/**
		 *  if this value equals 0 or below 0, the agent will "hungry". 
		 */
		String FullPoint = "FP";
		
		String DirtyPoint = "DP";
		String SickPoint = "SP";
		String MovePoint = "MP";
		String ActionPoint = "AP";
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
