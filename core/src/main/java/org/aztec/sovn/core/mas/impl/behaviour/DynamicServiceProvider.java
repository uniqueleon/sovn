package org.aztec.sovn.core.mas.impl.behaviour;

import org.aztec.sovn.core.mas.BDIAgent;

import jade.core.behaviours.CyclicBehaviour;

public class DynamicServiceProvider extends CyclicBehaviour {


	@Override
	public void action() {

		BDIAgent self = AgentHelper.cast2BDIAgent(getAgent());
		if (self != null) {
			
		}
	}

}
