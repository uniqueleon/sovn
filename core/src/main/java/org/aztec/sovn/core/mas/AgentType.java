package org.aztec.sovn.core.mas;

public interface AgentType {

	public String getTypeName();
	public Class<? extends BDIAgent> getAgentCls();
}
