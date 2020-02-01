package org.aztec.sovn.core.mas.impl;

import java.util.Map;

import org.aztec.sovn.core.mas.AgentConstant.MathOperator;
import org.aztec.sovn.core.mas.AgentException;
import org.aztec.sovn.core.mas.Status;
import org.aztec.sovn.core.mas.utils.GenericNumberUtils;

import com.google.common.collect.Maps;



public abstract class MapBasedStatus implements Status {
	
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

	@Override
	public void operateNumber(String name, Number amount,MathOperator operator) {
		// TODO Auto-generated method stub
		if(attributes.containsKey(name)) {
			Number number1 = (Number) attributes.get(name);
			attributes.put(name, GenericNumberUtils.operate(number1, amount, operator));
		}
	}

	@Override
	public void assertNotNull(String... attrName) throws AgentException {
		
		for(String attr : attrName) {
			if(!attributes.containsKey(attr)) {
				throw new AgentException("The attribute " + attr + " is not exists!");
			}
		}
	}
	
	
}
