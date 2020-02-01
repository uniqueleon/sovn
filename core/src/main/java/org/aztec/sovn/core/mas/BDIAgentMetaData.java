package org.aztec.sovn.core.mas;

import java.util.List;

/**
 * the meta data of BDI-Agent.
 * BDI Agent 元数据.
 * 
 * @author uniqueleon
 *
 */
public interface BDIAgentMetaData {

	public long getRateOfReaction();
	public List<Status> getInitialStatus();
	public AgentType getType();
}
