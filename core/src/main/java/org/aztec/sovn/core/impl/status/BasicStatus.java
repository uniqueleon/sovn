package org.aztec.sovn.core.impl.status;

import java.util.List;

import org.aztec.sovn.core.StatusValidator;
import org.aztec.sovn.core.impl.MapBasedStatus;

public abstract class BasicStatus extends MapBasedStatus {
	
	protected abstract List<StatusValidator> getValidators();

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
		List<StatusValidator> validators = getValidators();
		if(validators != null) {
			validators.stream().forEach(validator -> {
				validator.validate(this);
			});
		}
	}

}
