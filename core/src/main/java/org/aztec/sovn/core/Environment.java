package org.aztec.sovn.core;

import java.util.Map;

public interface Environment {

	public Map<String,Object> getProperties();
	public Object getProperty(String name);
	public void setProperty(String name,Object value);
}
