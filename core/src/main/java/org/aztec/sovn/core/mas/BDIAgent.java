package org.aztec.sovn.core.mas;

import reactor.core.publisher.Flux;

/**
 * A rational intelligent artifact which based on the BDI model<br>
 * 
 * 基于BDI模型理性智能体。<br>
 * 
 * @author liming
 *
 */
public interface BDIAgent {

	public String getName();
	public Belief getBeliefs();
	public BDIAgentMetaData getMetaData();
	public void setBelief(Belief belief);
	public void setDesire(Flux<Desire> desires);
	public Flux<Desire> getCurrentDesire();
}
