package org.aztec.sovn.core.impl.kownledge;

import org.aztec.sovn.core.Kownledge;

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
