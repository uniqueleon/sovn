package org.aztec.sovn.core.impl;

import java.util.Map;

import org.aztec.sovn.core.Kownledge;
import org.aztec.sovn.core.Meaning;

import com.google.api.client.util.Maps;

public abstract class MapBasedKownledge implements Kownledge {
	
	protected Map<String,Object> attributes = Maps.newHashMap();
	
	
	protected abstract void validate(String name,Object value);

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

}
