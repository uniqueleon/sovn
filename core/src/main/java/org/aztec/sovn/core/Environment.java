package org.aztec.sovn.core;

import java.util.Map;

public interface Environment {

	public Map<String,Kownledge> Kownledge();
	public Kownledge Kownledge(String name);
	public void setKownledge(String name,Object value);
}
