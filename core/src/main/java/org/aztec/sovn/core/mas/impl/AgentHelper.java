package org.aztec.sovn.core.mas.impl;

import org.aztec.sovn.core.mas.BDIAgent;

import jade.core.Agent;

public class AgentHelper {

	public AgentHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public static BDIAgent cast2BDIAgent(Agent agent) {
		if(agent != null && agent.isAlive() && agent instanceof BDIAgent) {
			return (BDIAgent) agent;
		}
		return null;
	}

}
