package org.aztec.sovn.core;

import java.util.Map;

/**
 * the knowledge of the world (from Agent).</br>
 * Agent对世界的认知
 * 
 * @author liming
 *
 */
public interface Kownledge {

	
	public Map<String,Object> getAttributes();
	public Object getAttribute(String name);
	public void setAttribute(String name,Object value);
}
