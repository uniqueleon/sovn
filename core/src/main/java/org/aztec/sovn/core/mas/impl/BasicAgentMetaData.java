package org.aztec.sovn.core.mas.impl;

import org.aztec.sovn.core.mas.AgentType;
import org.aztec.sovn.core.mas.BDIAgentMetaData;
import org.aztec.sovn.core.mas.Status;

public class BasicAgentMetaData implements BDIAgentMetaData {
	
	private long rateOfReation;
	private Status initialStatus;
	private AgentType type;
	private long sleepInterval;

	public BasicAgentMetaData() {
		// TODO Auto-generated constructor stub
	}

	public BasicAgentMetaData(long rateOfReation, Status initialStatus, AgentType type, long sleepInterval) {
		super();
		this.rateOfReation = rateOfReation;
		this.initialStatus = initialStatus;
		this.type = type;
		this.sleepInterval = sleepInterval;
	}
	
	@Override
	public long getRateOfReaction() {
		return rateOfReation;
	}

	@Override
	public long getSleepInterval() {
		return sleepInterval;
	}

	@Override
	public Status getInitialStatus() {
		return initialStatus;
	}

	@Override
	public AgentType getType() {
		return type;
	}

}
