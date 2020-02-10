package org.aztec.sovn.core.mas.impl.term;

import org.springframework.stereotype.Component;

public abstract class InternalTerm extends BasicTerm {

	public InternalTerm(String name) {
		super("INTERNAL_" + name);
	}

	@Override
	public boolean isOuterService() {
		return false;
	}

	@Override
	public boolean isInnerService() {
		return true;
	}

	@Override
	public boolean isComputional() {
		return true;
	}


}
