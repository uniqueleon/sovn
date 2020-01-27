package org.aztec.sovn.core;

/**
 * A rational intelligent artifact.<br>
 * 
 * 理性智能体<br>
 * 
 * @author liming
 *
 */
public interface Agent {

	public Belief getBelief();
	public Desire getDesire();
	public Intension getIntension();
}
