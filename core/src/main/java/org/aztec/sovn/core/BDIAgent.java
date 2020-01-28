package org.aztec.sovn.core;

/**
 * A rational intelligent artifact which based on the BDI model<br>
 * 
 * 基于BDI模型理性智能体。<br>
 * 
 * @author liming
 *
 */
public interface BDIAgent {

	public Belief getBeliefs();
	public Desire getDesire();
	public Intension getIntension();
}
