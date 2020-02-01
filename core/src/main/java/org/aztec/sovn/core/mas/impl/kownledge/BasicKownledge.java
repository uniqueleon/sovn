package org.aztec.sovn.core.mas.impl.kownledge;

import org.aztec.sovn.core.mas.Kownledge;

public abstract class BasicKownledge implements Kownledge{
	
	protected String name;

	public BasicKownledge(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}


}
