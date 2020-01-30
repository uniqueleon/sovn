package org.aztec.sovn.core.impl.behaviour;

import java.util.List;

import org.aztec.sovn.core.BDIAgent;
import org.aztec.sovn.core.Belief;
import org.aztec.sovn.core.MeaningInterpreter;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Sensor extends CyclicBehaviour {

	boolean isRunnable = false;

	@Override
	public void action() {
		Agent agent = super.getAgent();
		if (agent instanceof BDIAgent) {
			BDIAgent self = (BDIAgent) agent;
			Belief beliefs = self.getBeliefs();
			List<MeaningInterpreter> interpreters = beliefs.getInterpreters();
			
		}
		if(isRunnable) {
			block();
		}
	}

}
