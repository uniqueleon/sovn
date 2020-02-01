package org.aztec.sovn.core.mas.impl.kownledge;

import org.aztec.sovn.core.mas.Kownledge;

public abstract class BaseKownledge implements Kownledge{
	
	protected String name;

	public BaseKownledge(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}


}
