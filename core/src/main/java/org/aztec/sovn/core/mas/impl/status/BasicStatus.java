package org.aztec.sovn.core.mas.impl.status;

import java.util.List;

import org.aztec.sovn.core.mas.StatusValidator;
import org.aztec.sovn.core.mas.impl.MapBasedStatus;

public abstract class BasicStatus extends MapBasedStatus {
	
	protected abstract List<StatusValidator> getValidators();

	

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
