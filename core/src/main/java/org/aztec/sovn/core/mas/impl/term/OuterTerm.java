package org.aztec.sovn.core.mas.impl.term;

import org.springframework.stereotype.Component;

@Component
public abstract class OuterTerm extends BasicTerm {

	public OuterTerm() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isOuterService() {
		return true;
	}

	@Override
	public boolean isInnerService() {
		return false;
	}

}
