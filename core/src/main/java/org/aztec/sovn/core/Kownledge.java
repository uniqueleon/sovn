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

	public String name();
	
	public Desire toDesire();
	
	public void effect(BDIAgent agent);
}
