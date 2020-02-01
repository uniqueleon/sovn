package org.aztec.sovn.core.mas.impl.plan;

import org.aztec.sovn.core.mas.BDIAgent;

import jade.core.Agent;

public class Dead extends BasicPlan {

	public Dead() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doRun(BDIAgent agent) throws Exception {
		if(agent instanceof Agent) {
			Agent jadeAgent = (Agent) agent;
			jadeAgent.doDelete();
		}
	}

	@Override
	protected boolean shouldBeContinue() {
		// TODO Auto-generated method stub
		return false;
	}

}
