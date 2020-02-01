package org.aztec.sovn.core.mas;

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
	
	public static enum BaseKownledge{
		STATUS_NUMBER_UPDATE,
		STATUS_MESSAGE_UPDATE,
		STATUS_FLAG_UPDATE,
		TALK,
		SLEEP,
		WAKEUP,
		DEAD;
	}
}
