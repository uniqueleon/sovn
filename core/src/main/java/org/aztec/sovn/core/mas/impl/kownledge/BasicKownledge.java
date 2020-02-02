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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicKownledge other = (BasicKownledge) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
