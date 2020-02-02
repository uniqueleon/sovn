package org.aztec.sovn.core.mas.impl.term;

import org.springframework.stereotype.Component;

@Component
public abstract class InternalTerm extends BasicTerm {

	public InternalTerm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isOuterService() {
		return false;
	}

	@Override
	public boolean isInnerService() {
		return true;
	}

}
