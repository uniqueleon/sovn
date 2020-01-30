package org.aztec.sovn.core;

import java.util.Map;

public interface Status {

	
	public Map<String,Object> getAttributes();
	public Object getAttribute(String name);
	public void setAttribute(String name,Object value);
}
