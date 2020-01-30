package org.aztec.sovn.core.impl.kownledge;

import org.aztec.sovn.core.impl.MapBasedKownledge;

public class HealthKownledge extends MapBasedKownledge {

	public static interface HealthKeys{
		// if this value equals 0 or below 0, the agent will "die".
		String HealthPoint = "HP";
		// if this value equals 0 or below 0, the agent will "hungry". 
		String FullPoint = "FP";
		
		String DirtyPoint = "DP";
		String SickPoint = "SP";
		String MovePoint = "MP";
		String ActionPoint = "AP";
	}

	@Override
	protected void validate(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

}
