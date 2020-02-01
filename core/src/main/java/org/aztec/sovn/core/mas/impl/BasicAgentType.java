package org.aztec.sovn.core.mas.impl;

import org.aztec.sovn.core.mas.AgentType;
import org.aztec.sovn.core.mas.BDIAgent;

public class BasicAgentType implements AgentType {
	
	public static final String BASE_AGENT_TYPE_NAME = "SOVN_MAS_BASE_AGENT";

	public BasicAgentType() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTypeName() {
		return BASE_AGENT_TYPE_NAME;
	}

	@Override
	public Class<? extends BDIAgent> getAgentCls() {
		return BasicBDIAgent.class;
	}

}
