package org.aztec.sovn.core.mas.impl.term;

import org.springframework.stereotype.Component;

@Component
public abstract class OuterTerm extends BasicTerm {

	public OuterTerm(String name) {
		super("OUTER_TERM_" + name);
	}

	@Override
	public boolean isOuterService() {
		return true;
	}

	@Override
	public boolean isInnerService() {
		return false;
	}

	@Override
	public boolean isComputional() {
		return true;
	}

	
}
