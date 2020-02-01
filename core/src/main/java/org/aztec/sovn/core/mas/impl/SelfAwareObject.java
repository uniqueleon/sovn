package org.aztec.sovn.core.mas.impl;

import org.aztec.sovn.core.mas.BDIAgent;
import org.aztec.sovn.core.mas.SelfAware;

public class SelfAwareObject implements SelfAware {
	

	protected BDIAgent self;

	public SelfAwareObject(BDIAgent self) {
		this.self = self;
	}

	@Override
	public BDIAgent getSelf() {
		return self;
	}

}
