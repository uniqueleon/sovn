package org.aztec.sovn.core.mas;

import java.util.Map;

import org.aztec.sovn.core.mas.AgentConstant.MathOperator;

/**
 * The status of Agent.</br>
 * Agent状态
 * @author uniqueleon
 *
 */
public interface Status {

	
	public Map<String,Object> getAttributes();
	public  <T> T getAttribute(String name);
	public void setAttribute(String name,Object value);
	public void operateNumber(String name,Number amount,MathOperator operator);
	public void assertNotNull(String... attrName) throws AgentException;
	public enum StatusAttributes {
		
	}
}
