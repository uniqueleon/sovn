package org.aztec.sovn.core.mas;

import java.util.Map;

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
	
	public enum StatusAttributes {
		
	}
}
